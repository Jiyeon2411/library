package com.library.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.library.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long>{

	/* @Query("select o from Loan o where o.member.email = :email order by o.loan_date desc")
	List<Loan> findLoans(@Param("email") String email, Pageable pageable);
	
	@Query("select o from loan o order by o.loan_date asc")
	List<Loan> findAllLoans(Pageable pageable); */
}
