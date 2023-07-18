package com.library.dto;

import com.library.entity.Member;

import lombok.*;

@Getter
@Setter
public class RecBookDto {
	private String title;
	private String content;
	private Member member;
}
