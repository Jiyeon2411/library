package com.library.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	public String title;
	
	public String author;
	
	public String publisher;
	
	public String book_id;
	
	
}
