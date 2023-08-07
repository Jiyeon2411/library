package com.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.library.dto.LoanBookDto;
import com.library.dto.LoanHistDto;
import com.library.entity.Book;
import com.library.entity.Loan;
import com.library.entity.Member;
import com.library.repository.BookRepository;
import com.library.repository.LoanRepository;
import com.library.repository.MemberRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class LoanService {

	private final MemberRepository memberRepo;
    private final LoanRepository loanRepo;
    private final BookRepository bookRepo;
    
    public List<LoanHistDto> getAllLoanList() {
        List<LoanHistDto> dtos;

        List<Loan> loanList = loanRepo.findAll();

        dtos = loanList.stream()
                .map(LoanHistDto::of)
                .collect(Collectors.toList());

        return dtos;
    }
}
