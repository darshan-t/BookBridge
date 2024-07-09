package com.example.BookBridge.service;

import com.example.BookBridge.entity.Author;
import com.example.BookBridge.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuhtors(){
        return authorRepository.findAll();
    }

    public Author getAuhtorById(Long id){
        Author author=authorRepository.findById(id).orElseThrow(()->new RuntimeException(("Author not found")));
        return author;
    }

    public void createAuthor(Author author){
        authorRepository.save(author);
    }

    public void deleteAuthor(Long id){
        Author author= authorRepository.findById(id).orElseThrow(()->new RuntimeException("Author not found"));
        authorRepository.deleteById(author.getId());
    }

    public void updateAuthor(Author author){
        authorRepository.save(author);
    }
}
