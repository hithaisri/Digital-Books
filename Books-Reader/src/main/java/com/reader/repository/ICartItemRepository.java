package com.reader.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reader.entity.CartItem;

public interface ICartItemRepository extends JpaRepository<CartItem, Integer>{
	
	List<CartItem> findByUserId(Integer userId);

}
