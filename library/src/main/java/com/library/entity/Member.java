package com.library.entity;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.library.constant.Role;
import com.library.dto.MemberFormDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="member")
@Getter
@Setter
@ToString
public class Member {

	@Id
	@Column(name="member_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String password;
	
	private String email;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
		
		Member member = new Member();
		member.setName(memberFormDto.getName());
		member.setEmail(memberFormDto.getEmail());
		
		String password = passwordEncoder.encode(memberFormDto.getPassword());
		
		member.setPassword(password);
		
		member.setRole(Role.USER);
		member.setRole(Role.ADMIN);
		
		return member;
	}
}
