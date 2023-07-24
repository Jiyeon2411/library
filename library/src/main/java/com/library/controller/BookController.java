package com.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.library.dto.BookSearchDto;
import com.library.dto.LoanBookDto;
import com.library.entity.Book;
import com.library.service.BookService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {
	
	private final BookService bookService;
	
	@GetMapping(value = {"/loan/loanBook", "/loan/loanBook/{page}"})
	public String loanBook(BookSearchDto booksearchdto,
			@PathVariable("page") Optional<Integer> page, Model model) {
		
		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 5);
		
		Page<Book> books = bookService.getBookPage(booksearchdto, pageable);
		
		model.addAttribute("books", books);
		model.addAttribute("booksearchdto", booksearchdto);
		model.addAttribute("maxPage", 5);
		
		return "loan/loanBook";
	}
	
}
