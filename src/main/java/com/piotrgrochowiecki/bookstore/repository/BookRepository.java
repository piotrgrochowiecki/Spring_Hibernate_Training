package com.piotrgrochowiecki.bookstore.repository;

import com.piotrgrochowiecki.bookstore.model.Book;
import com.piotrgrochowiecki.bookstore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findBookByTitle(String title);

    List<Book> findBooksByCategory(Category category);

    List<Book> findBooksByCategoryId(Long id);

}
