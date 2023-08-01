package com.library.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.dto.LoanBookDto;
import com.library.dto.RecBookDto;
import com.library.service.RecBookService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RecBookController {
	@Autowired
	private RecBookService recBookService;
	
	public RecBookController(RecBookService recBookService) {
		this.recBookService = recBookService;
	}
	
	@GetMapping("/rec/recList")
	public String list(Model model) {
		List<RecBookDto> recBookDtoList = recBookService.getRecList();
		model.addAttribute("recBookList", recBookDtoList);
		return "rec/recList";
	}
	
	/* @GetMapping(value = "/rec/recList")
	public String recList() {
		return "rec/recList";
	} */
	
	@GetMapping(value = "/rec/recCreate")
	public String rec() {
		return "rec/recCreate";
	}
	
	@PostMapping(value = "/rec/recCreate")
	public String recCreate(RecBookDto recBookdto) {
		recBookService.savePost(recBookdto);
		return "redirect:/";
	}
}
