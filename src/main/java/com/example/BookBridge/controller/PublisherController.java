package com.example.BookBridge.controller;

import com.example.BookBridge.entity.Category;
import com.example.BookBridge.entity.Publisher;
import com.example.BookBridge.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/publishers")
    public String getAllPublishers(Model model){
        model.addAttribute("publishers",publisherService.getAllPublishers());
        return "publishers";
    }
    @GetMapping("/remove-publisher/{id}")
    public String deletePublisher(@PathVariable Long id, Model model){
        publisherService.deletePublisher(id);
        model.addAttribute("publishers",publisherService.getAllPublishers());
        return "publishers";
    }

    @GetMapping("/update-publisher/{id}")
    public String updatePublisher(@PathVariable Long id, Model model){
        model.addAttribute("publisher",publisherService.getPublisherById(id));
        return "update-publisher";
    }
    @PostMapping("/update-publisher/{id}")
    public String updatePublisher(@PathVariable Long id, Publisher publisher, BindingResult result, Model model){
        if(result.hasErrors()){
            return "update-publisher";
        }
        publisherService.updatePublisher(publisher);
        model.addAttribute("publishers",publisherService.getAllPublishers());
        return "redirect:/publishers";
    }

    @GetMapping("/add-publisher")
    public String showCreatePublisher(Publisher publisher,Model model){
        model.addAttribute("publisher",publisher);
        return "add-publisher";
    }
    @PostMapping("/save-publisher")
    public String savePublisher(Publisher publisher, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-publisher";
        }
        publisherService.createPublisher(publisher);
        model.addAttribute("publishers",publisherService.getAllPublishers());
        return "redirect:/publishers";
    }
}
