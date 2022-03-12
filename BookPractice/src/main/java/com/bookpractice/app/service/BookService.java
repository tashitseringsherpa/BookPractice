package com.bookpractice.app.service;

import java.util.List;

import com.bookpractice.app.vo.BookVo;

public interface BookService {
	
	public String createBookForm(BookVo book);
	
	public List<BookVo> allBook();
	
	public String deleteBook(int id);
	

	public BookVo findUserById(int id);
	
	public String editBookServlet(BookVo book);
	
}
