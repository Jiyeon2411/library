package com.library.service;

import java.util.List;

import com.library.dto.RecBookDto;

public interface RecBookService {
	public int maxNum() throws Exception;
	
	public void insertData(RecBookDto recbookdto) throws Exception;
	
	public int getDataCount(String searchKey, String searchValue) throws Exception;
	
	public List<RecBookDto> getLists(int start, int end, String searchKey, String searchValue) throws Exception;
	
	public void updateHitCount(int num) throws Exception;
	
	public RecBookDto getReadData(int num) throws Exception;
	
	public void updateData(RecBookDto recbookdto) throws Exception;
	
	public void deleteData(int num) throws Exception;
}
