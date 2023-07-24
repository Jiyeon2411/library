package com.library.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.library.dto.BookSearchDto;
import com.library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryCustom{

	//Page<Book> getBookPage(BookSearchDto booksearchdto, Pageable pageable);

	//List<Book> findByBookNm(String title);
}
