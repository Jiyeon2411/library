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
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class LoanService {

	private final MemberRepository memberRepo;
    private final LoanRepository loanRepo;
    private final BookRepository bookRepo;
    
    
}
