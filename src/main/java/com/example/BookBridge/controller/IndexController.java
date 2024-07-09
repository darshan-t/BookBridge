package com.example.BookBridge.controller;


import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {
    @GetMapping("/")
    public String home(){
        return "index";
    }
}
