package com.piotrgrochowiecki.bookstore.repository;

import com.piotrgrochowiecki.bookstore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findCategoryByName(String name);

    Optional<Category> findCategoryById(Long id);
}
