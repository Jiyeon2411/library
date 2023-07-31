package com.library.dto;

import com.library.entity.RecBook;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RecBookDto {
	private Long id;
	private String title;
	private String publisher;
	
	public RecBook toEntity() {
		RecBook build = RecBook.builder()
				.id(id)
				.title(title)
				.publisher(publisher)
				.build();
		return build;
	}
	
	@Builder
	public RecBookDto(Long id, String title, String publisher) {
		this.id = id;
		this.title = title;
		this.publisher = publisher;
	}
}
