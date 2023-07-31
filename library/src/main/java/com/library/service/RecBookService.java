package com.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.LoanBookDto;
import com.library.dto.RecBookDto;
import com.library.entity.Book;
import com.library.entity.Loan;
import com.library.entity.Member;
import com.library.entity.RecBook;
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
public class RecBookService {
	@Autowired
	private RecBookRepository recRepo;
    
	public RecBookService(RecBookRepository recRepo) {
		this.recRepo = recRepo;
	}
	
	@Transactional
	public Long savePost(RecBookDto recBookDto) {
		return recRepo.save(recBookDto.toEntity()).getId();
	}
	
	@Transactional
	public List<RecBookDto> getRecList() {
		List<RecBook> recBookList = recRepo.findAll();
		List<RecBookDto> recBookDtoList = new ArrayList<>();
		
		for(RecBook recbook : recBookList) {
			RecBookDto recBookDto = RecBookDto.builder()
					.id(recbook.getId())
					.title(recbook.getTitle())
					.publisher(recbook.getPublisher())
					.build();
			recBookDtoList.add(recBookDto);
		}
		return recBookDtoList;
	}
}
