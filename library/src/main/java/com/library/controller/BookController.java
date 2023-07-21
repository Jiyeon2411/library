package com.library.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.library.entity.Book;
import com.library.service.BookService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {
	
	private final BookService bookService;
	
	@GetMapping(value = "/loan/loanBook")
	public String loanBook() {
		return "loan/loanBook";
	}
	
	/*@GetMapping
	public List<Book> findAll() {
		return bookService.findAll();
	}
	
	@PostMapping
	public Book create(@Valid @RequestBody Book book) {
		return bookService.addBook(book);
	}*/
}
