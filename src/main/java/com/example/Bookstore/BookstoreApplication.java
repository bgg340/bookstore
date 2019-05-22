package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
	return (args) -> {
		
		Category c1 = new Category("Poop");
		Category c2 = new Category("Horror");
		
		crepository.save(c1);
		crepository.save(c2);
		
		Book b1 = new Book("Liiba", "John Laaba", 1994, "a1234", 21.30, c1 );
		Book b2 = new Book("Laaba", "John Liiba", 1996, "a1233443", 13.30, c1 );
		Book b3 = new Book("Sörs Lälälä", "John Laaba", 2005, "a33342", 31.30, c2 );
		
		
		repository.save(b1);
		repository.save(b2);
		repository.save(b3);
		
	};
	}
	
}

