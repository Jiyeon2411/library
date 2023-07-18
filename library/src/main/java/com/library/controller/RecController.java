package com.library.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library.dto.RecBookDto;
import com.library.service.RecBookService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class RecController {
	@Autowired
	private RecBookService recbookservice;
	
	
	@RequestMapping(value = "/recbook", method = {RequestMethod.GET, RequestMethod.POST})
	public String recBook(RecBookDto recbookdto, HttpServletRequest request, Model model) {
		
		String pageNum = request.getParameter("pageNum");
		int currentPage = 1;
		
		if(pageNum != null) {
			currentPage = Integer.parseInt(pageNum);
			
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		if(searchValue == null) {
			searchKey = "subject";
			searchValue = "";
		} else {
			if(request.getMethod().equalsIgnoreCase("GET")) {
				try {
					searchValue = URLDecoder.decode(searchValue, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		}
		return pageNum;
	}
}
