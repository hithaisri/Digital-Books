package com.author.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.author.entity.Books;

public interface IBookRepoistory extends JpaRepository<Books, Integer>{

	List<Books> findByTitle(String title);
	
	List<Books> findByPublisher(String publisher);
	
	List<Books> findByPrice(Integer price);
	
}
