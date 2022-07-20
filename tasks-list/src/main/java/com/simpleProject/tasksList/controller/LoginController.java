package com.simpleProject.tasksList.controller;

import com.simpleProject.tasksList.dto.UserDto;
import com.simpleProject.tasksList.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerNawUser(@Valid @ModelAttribute("user") UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        if (!userDto.getPassword().equals(userDto.getRepeatPassword())) {
            bindingResult.rejectValue("password", "", "passwords don't match");
            return "register";
        }
        userService.create(userDto);
        return "redirect:/login";
    }
}
