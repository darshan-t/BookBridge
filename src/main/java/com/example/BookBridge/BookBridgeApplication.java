package com.example.BookBridge;

import com.example.BookBridge.entity.Author;
import com.example.BookBridge.entity.Book;
import com.example.BookBridge.entity.Category;
import com.example.BookBridge.entity.Publisher;
import com.example.BookBridge.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookBridgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookBridgeApplication.class, args);
	}
    @Bean
	public CommandLineRunner initialCreate(BookService bookService) {
		return (args) -> {
			Book book1 = new Book("978-0439708180", "Harry Potter and the Sorcerer's Stone", "A young wizard's journey begins");
			Author author1 = new Author("J.K. Rowling", "British author, best known for the Harry Potter series");
			Category category1 = new Category("Fantasy");
			Publisher publisher1 = new Publisher("Scholastic");
			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);
			bookService.createBook(book1);

			Book book2 = new Book("978-0061120084", "To Kill a Mockingbird", "A novel about racial injustice in the Deep South");
			Author author2 = new Author("Harper Lee", "American author known for her novel To Kill a Mockingbird");
			Category category2 = new Category("Classic Literature");
			Publisher publisher2 = new Publisher("Harper Perennial Modern Classics");
			book2.addAuthor(author2);
			book2.addCategory(category2);
			book2.addPublisher(publisher2);
			bookService.createBook(book2);


//			Book book3 = new Book("978-1449355739", "Fluent Python", "A hands-on guide to writing idiomatic Python code");
//			Author author3 = new Author("Luciano Ramalho", "Technical principal at ThoughtWorks and an experienced Python programmer");
//			Category category3 = new Category("Programming");
//			Publisher publisher3 = new Publisher("O'Reilly Media");
//			book3.addAuthor(author3);
//			book3.addCategory(category3);
//			book3.addPublisher(publisher3);
//			bookService.createBook(book3);

			Book book4 = new Book("978-0134685991", "Effective Java", "A comprehensive guide to best practices in Java programming");
			Author author4 = new Author("Joshua Bloch", "Software engineer and author, known for his contributions to the Java programming language");
			Category category4 = new Category("Programming");
			Publisher publisher4 = new Publisher("Addison-Wesley Professional");
			book4.addAuthor(author4);
			book4.addCategory(category4);
			book4.addPublisher(publisher4);
			bookService.createBook(book4);
		};
	}
	}

