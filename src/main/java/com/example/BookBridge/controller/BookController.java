package com.example.BookBridge.controller;

import com.example.BookBridge.entity.Book;
import com.example.BookBridge.entity.Category;
import com.example.BookBridge.entity.Publisher;
import com.example.BookBridge.service.AuthorService;
import com.example.BookBridge.service.BookService;
import com.example.BookBridge.service.CategoryService;
import com.example.BookBridge.service.PublisherService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/books")
    public String findAllBooks(Model model){
        List<Book> books=bookService.getAllBooks();
        model.addAttribute("books",books);
        return "books";
    }

    @GetMapping("/book/{id}")
    public String findBookById(@PathVariable Long id, Model model){
        Book book=bookService.getBookById(id);
        model.addAttribute("book",book);
        return "book-detail";
    }

    @GetMapping("/remove-book/{id}")
    public String delteBook(@PathVariable Long id,Model model){
        bookService.deleteBook(id);
        model.addAttribute("books",bookService.getAllBooks());
        return "books";
    }

    @GetMapping("/update-book/{id}")
    public String updateBook(@PathVariable Long id,Model model){
        Book book=bookService.getBookById(id);
        model.addAttribute("book",book);
        model.addAttribute("categories",categoryService.getAllCategories());
        model.addAttribute("publishers", publisherService.getAllPublishers());
        model.addAttribute("authors",authorService.getAllAuthors());
        return "update-book";
    }
    @PostMapping("/save-update/{id}")
    public String updateBook(@PathVariable Long id, Book book,BindingResult result, Model model){
        if (result.hasErrors()){
            return "update-book";
        }
        bookService.updateBook(book);
        model.addAttribute("books",bookService.getAllBooks());
        return "redirect:/books";
    }

    @GetMapping("/add-book")
    public String addBook(Book book,Model model){
        model.addAttribute("categories",categoryService.getAllCategories());
        model.addAttribute("publishers", publisherService.getAllPublishers());
        model.addAttribute("authors",authorService.getAllAuthors());
        return "add-book";
    }
    @PostMapping("/save-book")
    public String addBook(Book book, BindingResult result ,Model model){
        if (result.hasErrors()){
            return "add-book";
        }
        bookService.createBook(book);
        model.addAttribute("books",bookService.getAllBooks());
        return "redirect:/books";
    }
}
