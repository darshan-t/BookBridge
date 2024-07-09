package com.example.BookBridge.service;

import com.example.BookBridge.entity.Publisher;
import com.example.BookBridge.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> getAllPublishers(){
        return publisherRepository.findAll();
    }

    public Publisher getPublisherById(Long id){
        Publisher publisher=publisherRepository.findById(id).orElseThrow(()->new RuntimeException("Publisher not found"));
        return  publisher;
    }

    public void createPublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }

    public void updatePublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }

    public void deletePublisher(Long id){
        Publisher publisher=publisherRepository.findById(id).orElseThrow(()->new RuntimeException("Publisher not found"));
        publisherRepository.deleteById(publisher.getId());
    }
}
