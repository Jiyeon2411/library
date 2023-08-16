package com.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

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
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class RecBookService {
	@Autowired
	private RecBookRepository recRepo;
	private MemberRepository memRepo;
    
	public RecBookService(RecBookRepository recRepo) {
		this.recRepo = recRepo;
	}
	
	@Transactional
	public String savePost(RecBookDto recBookDto) {
		return recRepo.save(recBookDto.createRecBook()).getTitle();
	}
	
	@Transactional
	public List<RecBookDto> getRecList() {
		List<RecBook> recBookList = recRepo.findAll();
		List<RecBookDto> recBookDtoList = new ArrayList<>();
		
	
		for(RecBook recbook : recBookList) {
			RecBookDto recBookDto = RecBookDto.of(recbook);
			recBookDtoList.add(recBookDto);
		}
		
		return recBookDtoList;
	}
	
	@Transactional(readOnly = true)
	public boolean validateRec(Long id, String email) {
		Member curMember = memRepo.findByEmail(email);
		RecBook recBook = recRepo.findById(id)
									.orElseThrow(EntityNotFoundException::new);
		
		Member savedMember = recBook.getMember();
		
		if(!StringUtils.equals(curMember.getEmail(), savedMember.getEmail())) {
			return false;
		}
		
		return true;
		
	}
	
	public void deleteRec(Long id) {
		RecBook recBook = recRepo.findById(id)
				.orElseThrow(EntityNotFoundException::new);
		
		recRepo.delete(recBook);
	}
}
