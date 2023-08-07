package com.library.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.library.entity.Loan;
import com.library.entity.Member;

public interface LoanRepository extends JpaRepository<Loan, Long>{
	@Query("select o from Loan o where o.member = :member order by o.loan_date desc")
    Page<Loan> findByMember(@Param("member") Member member, Pageable pageable);
	
}
