package com.author.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.author.entity.CartItem;

public interface ICartItemRepository extends JpaRepository<CartItem, Integer>{

}
