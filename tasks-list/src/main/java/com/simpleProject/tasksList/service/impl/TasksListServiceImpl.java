package com.simpleProject.tasksList.service.impl;

import com.simpleProject.tasksList.model.TasksList;
import com.simpleProject.tasksList.repository.TaskListRepository;
import com.simpleProject.tasksList.service.TasksListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TasksListServiceImpl implements TasksListService {

    private final TaskListRepository taskListRepository;

    @Autowired
    public TasksListServiceImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public void update(TasksList tasksList, Long id) {
        if (taskListRepository.existsById(id)) {
            tasksList.setId(id);
            taskListRepository.save(new TasksList());
        }
    }

    @Override
    public void delete(Long id) {
        if (taskListRepository.existsById(id))
            taskListRepository.deleteById(id);
    }
}
