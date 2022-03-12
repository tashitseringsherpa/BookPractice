package com.bookpractice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookpractice.app.entity.BookEntity;

public interface BookRepo extends JpaRepository<BookEntity,Integer>{
	
	
}
