package com.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.library.dto.LoanBookDto;
import com.library.entity.Book;
import com.library.entity.Loan;
import com.library.entity.Member;
import com.library.repository.BookRepository;
import com.library.repository.LoanRepository;
import com.library.repository.MemberRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final MemberRepository memberRepo;
    private final LoanRepository loanRepo;
    private final BookRepository bookRepo;
    
    public Long loan(LoanBookDto loanbookdto, String email) {
    	
    	//List<Book> book = bookRepo.findByBookNm(loanbookdto.getTitle());
    	
    	//Member member = memberRepo.findByEmail(email);
    	
    	//List<LoanBook> loanBookList = new ArrayList<>();
    	
//    	LoanBook loanBook = LoanBook.createLoanBook(book);
//    	loanBookList.add(loanBook);
    	
    	//Loan loan = Loan.createLoan(member, loanBookList);
    	//loanRepo.save(loan);
    	
    	//return (long) loan.getLoan_id();
    	return null;
    }
}
