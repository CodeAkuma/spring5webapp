package com.example.springframework.spring5webapp.controller;

import com.example.springframework.spring5webapp.repositories.AuthorRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController
{
    private AuthorRepo authorRepo;

    public AuthorController(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model)
    {
        model.addAttribute("authors", authorRepo.findAll());

        return "authors";
    }
}
