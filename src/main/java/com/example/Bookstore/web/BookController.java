package com.example.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

		@GetMapping("/")
		public String whereDoIGo(Model model) {
			return "index";
		}
		
	
}
