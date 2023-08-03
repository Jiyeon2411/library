package com.library.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.library.dto.BookSearchDto;
import com.library.entity.Book;
import com.library.entity.Loan;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryCustom{

	//Page<Book> getBookPage(BookSearchDto booksearchdto, Pageable pageable);

	//List<Book> findByBookNm(String title);
	
	//@Query("select o from Loan o where o.member.email = :email order by o.loan_date desc")
	//List<Loan> findLoans(@Param("email") String email, Pageable pageable);
}
