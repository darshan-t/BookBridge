package com.example.BookBridge.controller;

import com.example.BookBridge.entity.Author;
import com.example.BookBridge.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public String getAllAuthors(Model model){
        model.addAttribute("authors",authorService.getAllAuthors());
        return "authors";
    }
    @GetMapping("/remove-author/{id}")
    public String deleteAuthor(@PathVariable Long id, Model model){
        authorService.deleteAuthor(id);
        model.addAttribute("authors",authorService.getAllAuthors());
        return "authors";
    }

    @GetMapping("/update-author/{id}")
    public String updateAuthor(@PathVariable Long id, Model model){
        model.addAttribute("author",authorService.getAuthorById(id));
        return "update-author";
    }
    @PostMapping("/update-author/{id}")
    public String updateAuthor(@PathVariable Long id, Author author, BindingResult result, Model model){
        if(result.hasErrors()){
            return "update-author";
        }
        authorService.updateAuthor(author);
        model.addAttribute("authors",authorService.getAllAuthors());
        return "redirect:/authors";
    }

    @GetMapping("/add-author")
    public String showCreateAuthor(Author author, Model model){
        model.addAttribute("author",author);
        return "add-author";
    }
    @PostMapping("/save-author")
    public String saveAuthor(Author author, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-author";
        }
        authorService.createAuthor(author);
        model.addAttribute("authors",authorService.getAllAuthors());
        return "redirect:/authors";
    }
}
