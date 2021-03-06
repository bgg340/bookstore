package com.example.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
		@Autowired
		private BookRepository repository;
		
		@Autowired
		private CategoryRepository crepository;
	
		@RequestMapping("/booklist")
		public String bookList(Model model) {
			model.addAttribute("books", repository.findAll());
			return "booklist";
		}
		
		@RequestMapping(value = "/add")
		public String addBook(Model model) {
			model.addAttribute("book", new Book());
			model.addAttribute("categories", crepository.findAll());
			return "addbook";
		}
		
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String save(Book book) {
			repository.save(book);
			return "redirect:booklist";
		}
		
		
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		public String deleteBook(@PathVariable("id") long bookId, Model model) {
			repository.deleteById(bookId);
			return "redirect:../booklist";
		}
		
		//edit
		@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
		public String editBook(@PathVariable("id") long bookId, Model model) {

			model.addAttribute("book", repository.findById(bookId));
			model.addAttribute("categories", crepository.findAll());
			return "editbook";
		}
		
		
		//restful
		@RequestMapping(value = "/books", method=RequestMethod.GET)
		@ResponseBody
		public List<Book> bookListRest() {
			return (List<Book>) repository.findAll();
			
		}
		
		@RequestMapping(value = "/book/{id}", method=RequestMethod.GET)
		@ResponseBody
		public Optional<Book> findBookRest(@PathVariable("id") Long bookId){
			return repository.findById(bookId);
		}
		
		@RequestMapping(value = "/book/{id}", method=RequestMethod.DELETE)
		@ResponseBody
		public String deleteRest(@PathVariable("id") Long bookId){
			
			String bookname = repository.findById(bookId).get().getTitle();
			
			repository.deleteById(bookId);
			
			return bookname + " deleted";
		}
		
		 @RequestMapping(value="/login")
		  public String login() {
		    return "login";
		  }
		
}
