package com.example.springsecurity_24_06.controller;

import com.example.springsecurity_24_06.entity.Article;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @GetMapping("/articles")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE', 'AUTHOR')")
    public String showArticleManagement() {
        return "article_management";
    }

    @PostMapping("/articles")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE', 'AUTHOR')")
    public String createArticle() {
        return "articles";
    }

    @GetMapping("/articles/{id}/edit")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE', 'AUTHOR')")
    public String showEditArticleForm(@PathVariable("id") Long id, Model model) {
        return "edit_article";
    }

    @PostMapping("/articles/{id}/edit")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE', 'AUTHOR')")
    public String updateArticle(@PathVariable("id") Long id, @ModelAttribute Article articleDto) {
        return "articles";
    }

    @PostMapping("/articles/{id}/delete")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE', 'AUTHOR')")
    public String deleteArticle(@PathVariable("id") Long id) {
        return "articles";
    }
}
