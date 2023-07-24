package com.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.library.dto.BookSearchDto;
import com.library.entity.Book;
import com.library.repository.BookRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

	private final BookRepository bookrepo;
	
	@Transactional
	public Page<Book> getBookPage(BookSearchDto booksearchdto, Pageable pageable) {
			Page<Book> bookPage = bookrepo.getBookPage(booksearchdto, pageable);
			return bookPage;
	}

}