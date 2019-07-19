package com.example.springframework.spring5webapp.controller;

import com.example.springframework.spring5webapp.repositories.BookRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController
{
    private BookRepo bookRepo;

    public BookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @RequestMapping("/books")
    public String getBooks(Model model)
    {
        model.addAttribute("books", bookRepo.findAll());

        // Tell Spring MVC to return a View called "books"
        return "books";
    }
}
