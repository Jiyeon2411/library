package com.library.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@PostMapping(value = "/loan/loanBook")
	public @ResponseBody ResponseEntity loan(@RequestBody @Valid LoanBookDto loanBookDto,
			BindingResult bindingResult, Principal principal) {
		
		if(bindingResult.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			
			for (FieldError fieldError : fieldErrors) {
				sb.append(fieldError.getDefaultMessage());
			}
			
			return new ResponseEntity<String>(sb.toString(), HttpStatus.BAD_REQUEST);
		}
		
		String email = principal.getName();
		Long loanId;
		
		try {
			loanId = bookService.loan(loanBookDto, email);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Long>(loanId, HttpStatus.OK);
	}
	
	@GetMapping(value = {"/loan/loanBook", "/loan/loanBook/{page}"})
	public String loanBook(BookSearchDto booksearchdto,
			@PathVariable("page") Optional<Integer> page, Model model) {
		
		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 10);
		
		Page<Book> books = bookService.getBookPage(booksearchdto, pageable);
		
		model.addAttribute("books", books);
		model.addAttribute("booksearchdto", booksearchdto);
		model.addAttribute("maxPage", 5);
		
		return "loan/loanBook";
	}
	
	@GetMapping(value = "/rec/recList")
	public String recList() {
		return "rec/recList";
	}
	
	@GetMapping(value = "/rec/recCreate")
	public String recCreate() {
		return "rec/recCreate";
	}
}
