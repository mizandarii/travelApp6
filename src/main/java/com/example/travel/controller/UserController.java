package com.example.travel.controller;

import com.example.travel.model.User;
import com.example.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")

public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String getAllUser(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/list";
    }
    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "users/details";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "users/create";
    }
    /**
    @PostMapping("/register")
    public String createUser(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/users/list";
    }**/
    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }


        @GetMapping("/register")
        public String showRegisterPage() {
            return "registration";  // Thymeleaf template file name without the extension
        }
    }



