package com.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.library.dto.BookSearchDto;
import com.library.dto.LoanBookDto;
import com.library.dto.LoanHistDto;
import com.library.dto.RecBookDto;
import com.library.entity.Book;
import com.library.entity.Loan;
import com.library.entity.Member;
import com.library.repository.BookRepository;
import com.library.repository.LoanRepository;
import com.library.repository.MemberRepository;
import com.library.repository.RecBookRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

	@Autowired
	private final MemberRepository memberRepo;
    private final LoanRepository loanRepo;
    private final BookRepository bookRepo;
	
    public Long loan(LoanBookDto loanbookdto, String email) {
	
		Book book = bookRepo.findById(loanbookdto.getId())
								.orElseThrow(EntityNotFoundException::new);
		
		Member member = memberRepo.findByEmail(email);
		
		List<Loan> loanList = new ArrayList<>();
		Loan loan = Loan.createLoan(member, loanbookdto.getId());
		loanList.add(loan);
		
		loan.setBook(book);
		loanRepo.save(loan);
		
		return loan.getId();
}
    
	@Transactional
	public Page<Book> getBookPage(BookSearchDto booksearchdto, Pageable pageable) {
			Page<Book> bookPage = bookRepo.getBookPage(booksearchdto, pageable);
			return bookPage;
	}

	/* public void loan(Long id, String email) {
		// TODO Auto-generated method stub
		
	} */
	
	
	
	//대출목록 가져오기
	/*@Transactional
	public Page<LoanBookDto> getLoanList(String email, Pageable pageable) {
		List<Loan> loans = loanRepo.findAll();
		
		List<LoanHistDto> loanHistDtos = new ArrayList<>();
		
		for(Loan loan : loans) {
			LoanHistDto loanHistDto = new LoanHistDto(loan);
		
		}
		return new PageImpl<>(loanHistDtos, pageable);
		
	}*/

}