package com.example.springsecurity_24_06.controller;

import com.example.springsecurity_24_06.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {
    @GetMapping("/profile")
    @PreAuthorize("hasRole('USER')")
    public String showUserProfile() {
        return "user_profile";
    }

    @PostMapping("/profile")
    @PreAuthorize("hasRole('USER')")
    public String updateUserProfile(@ModelAttribute User userProfileDto) {
        return "profile";
    }
}