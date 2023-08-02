package com.library.dto;

import lombok.*;

@Getter
@Setter
public class LoanBookDto {
	private Long id;
	private String title;
	private String author;
	private String publisher;
}