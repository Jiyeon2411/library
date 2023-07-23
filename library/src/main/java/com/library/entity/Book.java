package com.library.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="book")
@Getter
@Setter
@ToString
public class Book {

	@Id
	@Column(name="book_title")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String title;
	
	@Column(nullable = false)
	private String author;
	
	@Column(nullable = false)
	private String publisher;
	
	@Column(nullable = false)
	private String book_id;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="loan")
	private List<Loan> loan;
}
