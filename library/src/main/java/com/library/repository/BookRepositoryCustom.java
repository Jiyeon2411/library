package com.library.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.library.dto.BookSearchDto;
import com.library.entity.Book;
import com.library.entity.Loan;

public interface BookRepositoryCustom {
	
	Page<Book> getBookPage(BookSearchDto booksearchdto, Pageable pageable);

}
