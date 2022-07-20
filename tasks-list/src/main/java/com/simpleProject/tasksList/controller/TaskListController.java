package com.simpleProject.tasksList.controller;

import com.simpleProject.tasksList.model.TasksList;
import com.simpleProject.tasksList.model.User;
import com.simpleProject.tasksList.repository.TaskListRepository;
import com.simpleProject.tasksList.repository.UserRepository;
import com.simpleProject.tasksList.service.TasksListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Slf4j
@Controller
public class TaskListController {

    private final TaskListRepository repository;
    private final TasksListService tasksListService;
    private final UserRepository userRepository;

    @Autowired
    public TaskListController(TaskListRepository repository, TasksListService tasksListService, UserRepository userRepository) {
        this.repository = repository;
        this.tasksListService = tasksListService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String indexPage(Model model, Principal principal) {

        log.info("User name: {}",principal.getName());

        model.addAttribute("items", repository.findByUserUserName(principal.getName()));
        model.addAttribute("item", new TasksList());
        return "index";
    }

    @PostMapping
    public String createTasksList(TasksList tasksList,Principal principal) {

        log.info("User name: {}",principal.getName());

        User user = userRepository.findByUserName(principal.getName()).get();
        tasksList.setUser(user);
        repository.save(tasksList);
        return "redirect:/";
    }

    @PutMapping("/{id}")
    public String updateTasksList(TasksList tasksList, @PathVariable("id") Long id) {
        tasksListService.update(tasksList, id);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteTaskItem(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }
}
