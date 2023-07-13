package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {

	@GetMapping(value = "/members/login")
	public String loginMember() {
		return "member/LoginForm";
	}
	
	@GetMapping(value = "/members/signup")
	public String signupMember() {
		return "member/SignUpForm";
	}
}
