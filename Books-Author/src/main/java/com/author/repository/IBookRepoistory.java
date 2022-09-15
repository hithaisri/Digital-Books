package com.author.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.author.entity.Books;

public interface IBookRepoistory extends JpaRepository<Books, Integer>{

	List<Books> findByTitleAndActive(String title,boolean active);
	
	List<Books> findByPublisherAndActive(String publisher,boolean active);
	
	List<Books> findByPriceAndActive(Integer price,boolean active);
	
	List<Books> findByAuthorAndActive(String author,boolean active);
	
}
