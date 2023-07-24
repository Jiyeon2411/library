package com.library.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.library.constant.LoanStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="loan")
@Getter
@Setter
@ToString
public class Loan {
	
	@Id
	@Column(name="loan_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private LocalDateTime loan_date;
	
	private LocalDateTime loan_deadline;
	
	private LoanStatus loanstatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="member_id")
	private Member member;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="book_id")
	private Book book;
	
	
	/*
	public void addLoanBook(LoanBook loanBook) {
		this.loanBooks.add(loanBook);
		loanBook.setLoan(this);
	}
	
	public Loan createLoan(Member member, List<LoanBook> loanBookList) {
		Loan loan = new Loan();
		loan.setMember(member);
		
		for(LoanBook loanBook : loanBookList) {
			loan.addLoanBook(loanBook);
		}
		
		loan.setLoanstatus(LoanStatus.AVAILABLE);
		loan.setLoan_date(LocalDateTime.now());
		
		return loan;
	}
		
	public void cancelLoan() {
		this.loanstatus = LoanStatus.CANCEL;
		
		for(LoanBook loanBook: loanBooks) {
			loanBook.cancel();
		}
	}
	*/
}
