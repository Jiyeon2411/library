package com.library.dto;

import org.modelmapper.ModelMapper;

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
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	//dto -> entity
	public RecBook createRecBook() {
		return modelMapper.map(this, RecBook.class);
	}   
	
	//entity -> dto로 바꿈
	public static RecBookDto of(RecBook recBook) {
		return modelMapper.map(recBook, RecBookDto.class);
	}

	
	/*
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
	*/
	
}
