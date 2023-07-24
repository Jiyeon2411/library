package com.library.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.library.dto.BookSearchDto;
import com.library.entity.Book;

public interface BookRepositoryCustom {
	
	Page<Book> getBookPage(BookSearchDto booksearchdto, Pageable pageable);
}
