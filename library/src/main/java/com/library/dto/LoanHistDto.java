package com.library.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.library.constant.LoanStatus;
import com.library.entity.Loan;

public class LoanHistDto {
	private Long id;
	private LocalDateTime loan_date;
	private LocalDateTime loan_deadline;
	private LoanStatus loanstatus;
	
	private List<LoanBookDto> loanDtoList = new ArrayList<>();
	
	public LoanHistDto(Loan loan) {
		this.id = loan.getId();
		this.loan_date = loan.getLoan_date();
		this.loan_deadline = loan.getLoan_deadline();
		this.loanstatus = loan.getLoanstatus();
	}
	public void addLoanBookDto(LoanBookDto loanBookDto) {
		this.loanDtoList.add(loanBookDto);
	}
}
