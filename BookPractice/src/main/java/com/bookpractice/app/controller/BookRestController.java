package com.bookpractice.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bookpractice.app.service.BookService;
import com.bookpractice.app.vo.BookVo;

@RestController
public class BookRestController {
	@Autowired
	BookService service;

	@GetMapping("/api/books") // http://localhost:1234/api/books
	List<BookVo> home() {
		return service.allBook();
	}

	@GetMapping("/api/books/{id}")
	Optional<BookVo> one(@PathVariable Integer id) {
		Optional<BookVo> item = Optional.of(service.findUserById(id));
//		Need to return "item.orElseThrow()" so converted to "Optional"
		return item;
				
	}
}
