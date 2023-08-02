package com.library.controller;

import java.net.URLDecoder;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library.dto.RecBookDto;
import com.library.service.RecBookService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.*;

@Controller
public class MainController {
	
	@Autowired
	private RecBookService recBookService;
	
	@RequestMapping(value = "/")
	public String main() {
		return "main";
	}
	
	@GetMapping(value = "/")
	public String main(RecBookDto recBookDto, Optional<Integer> page, Model model) {
		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 5);
		List<RecBookDto> recBookDtoList = recBookService.getRecList();
		
		model.addAttribute("recBookList", recBookDtoList);
		
		return "main";
	}
	
	/*
	@RequestMapping (value = "/recbooklist", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(RecBookDto recbookdto, HttpServletRequest request, Model model) {
	
		String pageNum = request.getParameter("pageNum");
		int currentPage = 1;
		
		if(pageNum != null) 
			currentPage = Integer.parseInt(pageNum);
		
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		if(searchValue == null) {
			searchKey = "subject";
			searchValue = "";
		} else {
			if(request.getMethod().equalsIgnoreCase("GET")) {
				searchValue = URLDecoder.decode(searchValue, "UTF-8");
			}
		}
		
		int dataCount = recBookService.
	} */
}
