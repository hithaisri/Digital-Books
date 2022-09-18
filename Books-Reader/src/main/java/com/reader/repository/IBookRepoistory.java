package com.reader.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reader.entity.Books;

public interface IBookRepoistory extends JpaRepository<Books, Integer>{

	List<Books> findByTitleAndActive(String title,boolean active);

	List<Books> findByPublisherAndActive(String publisher,boolean active);

	List<Books> findByPriceAndActive(Integer price,boolean active);

	List<Books> findByActive(Boolean active);
	
	List<Books> findByAuthorIdAndActive(Integer authorId,Boolean active);
	

	@Query(value="select book.* from books book,user u where book.author_id=u.id and book.active=:flag and u.first_name=:author",nativeQuery=true)
	List<Books> getByAuthorAndActive(String author, boolean flag);


}
