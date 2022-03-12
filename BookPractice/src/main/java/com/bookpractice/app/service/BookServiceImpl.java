package com.bookpractice.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookpractice.app.entity.BookEntity;
import com.bookpractice.app.repository.BookRepo;
import com.bookpractice.app.vo.BookVo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepo repository;

	@Override
	public String createBookForm(BookVo book) {

//		Vo -> (copy) -> Entity -> (forward) -> repo

		BookEntity bookEntity = new BookEntity();
		BeanUtils.copyProperties(book, bookEntity);
		repository.save(bookEntity);

		return "successfully created";
	}

	@Override
	public List<BookVo> allBook() {
//		repository -> Entity ->(crate DTO obj) -> dto->jsp
		List<BookVo> list = new ArrayList<BookVo>();
		List<BookEntity> entity = repository.findAll();
		for (BookEntity bookEntity : entity) {
			BookVo vo = new BookVo();
			BeanUtils.copyProperties(bookEntity, vo);
			list.add(vo);
		}
		return list;
	}

	@Override
	public String deleteBook(int id) {
		repository.deleteById(id);
		return "Entry Deleted";
	}

	@Override
	public BookVo findUserById(int id) {
		BookVo vo = new BookVo();
		BookEntity foundBook = repository.findById(id).get();
		BeanUtils.copyProperties(foundBook, vo);
		System.out.println("ServImpl -> FoundBook: "+foundBook);
		System.out.println("ServImpl -> vo: "+ vo);
		return vo;
	}

	@Override
	public String editBookServlet(BookVo book) {
		BookEntity bookEntity = new BookEntity();
		BeanUtils.copyProperties(book, bookEntity);
		repository.save(bookEntity);
		return "successfully Edited";
	}

}

//	DOWNLOAD
// 	1. DISPLAY jsp
// 	2. fill form with data.. .findById().
//	2.1. use <input value=${data.id}>
// 	3. inside form, use data.id, data.name
// 	
// 	UPDLOAD
// 	4. editBookServlet ()

// @Component is a generic stereotype for any Spring-managed component or bean.
// @Repository is a stereotype for persistence layer.
// @Service is a stereotype for the service layer.
// @Controller is a stereotype for presentation layer (spring-MVC).
