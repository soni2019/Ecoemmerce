package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.Category;

@Repository
public interface ProductRepo extends JpaRepository<Category, Long> {

}
