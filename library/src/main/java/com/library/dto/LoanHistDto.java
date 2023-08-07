package com.library.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.library.constant.LoanStatus;
import com.library.entity.Loan;
import lombok.Data;

@Data
public class LoanHistDto {
   private Long id;
   private LocalDate loan_date;
   private LocalDateTime loan_deadline;
   private LoanStatus loanstatus;
   

   public LoanHistDto(Loan loan) {
      this.id = loan.getId();
      this.loan_date = loan.getLoan_date();
      this.loan_deadline = loan.getLoan_deadline();
      this.loanstatus = loan.getLoanstatus();
   }

   public LoanHistDto(Long id, LocalDate loanDate, LocalDateTime loanDeadline, LoanStatus loanstatus) {
      this.id = id;
      this.loan_date = loanDate;
      this.loan_deadline = loanDeadline;
      this.loanstatus = loanstatus;
   }

   public static LoanHistDto of(Loan loan){
      return new LoanHistDto(
            loan.getId(),
            loan.getLoan_date(),
            loan.getLoan_deadline(),
            loan.getLoanstatus()
      );
   }




} 