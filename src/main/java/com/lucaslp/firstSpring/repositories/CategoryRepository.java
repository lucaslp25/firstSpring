package com.lucaslp.firstSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaslp.firstSpring.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{ //SpringData JPA
	
	
	
	
}
