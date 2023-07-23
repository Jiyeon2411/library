package com.library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.constant.LoanStatus;
import com.library.entity.Book;
import com.library.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

	Optional<Loan> findByBookAndStatus(Book book, LoanStatus status);
	
}
