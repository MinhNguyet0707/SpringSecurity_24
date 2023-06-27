package com.example.springsecurity_24_06.controller;

import com.example.springsecurity_24_06.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/")
    public String getHome() {
        return "Home page";
    }
    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public String showUserManagement() {
        return "user_management";
    }

    @PostMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public String createUser() {
        return "users";
    }

    @GetMapping("/users/{id}/edit")
    @PreAuthorize("hasRole('ADMIN')")
    public String showEditUserForm(@PathVariable("id") Long id, Model model) {
        return "edit_user";
    }

    @PostMapping("/users/{id}/edit")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute User userDto) {
        return "users";
    }
}