package com.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Book;
import com.library.repository.BookRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

	@Autowired
	private final BookRepository bookrepo;
	
	public List<Book> findAll() {
		return bookrepo.findAll();
	}
	
	public Optional<Book> findById(Long id) {
		return bookrepo.findById(id);
	}
	
	public Book addBook(Book book) {
		return bookrepo.save(book);
	}
	
	public Book updateBook(Book book) {
		return bookrepo.save(book);
	}
	
	public void deleteById(Long id) {
		bookrepo.deleteById(id);
	}
}
