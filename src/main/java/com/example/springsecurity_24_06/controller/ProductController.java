package com.example.springsecurity_24_06.controller;

import com.example.springsecurity_24_06.entity.Product;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    @GetMapping("/products")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String showProductManagement() {
        // Trả về view product_management.html
        return "product_management";
    }

    @PostMapping("/products")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String createProduct() {

        return "products";
    }

    @GetMapping("/products/{id}/edit")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String showEditProductForm(@PathVariable("id") Long id, Model model) {

        return "edit_product";
    }

    @PostMapping("/products/{id}/edit")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String updateProduct(@PathVariable("id") Long id, @ModelAttribute Product productDto) {

        return "products";
    }

    @PostMapping("/products/{id}/delete")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String deleteProduct(@PathVariable("id") Long id) {

        return "products";
    }
}

