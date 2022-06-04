package com.piotrgrochowiecki.bookstore.repository;

import com.piotrgrochowiecki.bookstore.model.Author;
import com.piotrgrochowiecki.bookstore.model.Book;
import com.piotrgrochowiecki.bookstore.model.Category;
import com.piotrgrochowiecki.bookstore.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findBookByTitle(String title);

    List<Book> findBooksByCategory(Category category);

    List<Book> findBooksByCategoryId(Long id);

    List<Book> findBooksByAuthor(Author author);

    List<Book> findBooksByPublisher(Publisher publisher);

    List<Book> findBooksByRating(int rating);

    Optional<Book> findFirstBookByCategoryOrderByTitle(Category category);

}
