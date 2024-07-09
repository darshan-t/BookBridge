package com.example.BookBridge.service;

import com.example.BookBridge.entity.Book;
import com.example.BookBridge.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id){
        Book book=bookRepository.findById(id).orElseThrow(()->new RuntimeException(("Book not found")));
        return book;
    }

    public void createBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(Long id){
        Book book= bookRepository.findById(id).orElseThrow(()->new RuntimeException("Boook not found"));
        bookRepository.deleteById(book.getId());
    }

    public void updateBook(Book book){
          bookRepository.save(book);
    }
}
