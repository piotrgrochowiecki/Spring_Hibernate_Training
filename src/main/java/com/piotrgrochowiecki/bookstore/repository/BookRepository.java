package com.piotrgrochowiecki.bookstore.repository;

import com.piotrgrochowiecki.bookstore.model.Author;
import com.piotrgrochowiecki.bookstore.model.Book;
import com.piotrgrochowiecki.bookstore.model.Category;
import com.piotrgrochowiecki.bookstore.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findBookByTitle(String title);

    List<Book> findBooksByCategory(Category category);

    List<Book> findBooksByCategoryId(Long id);

    List<Book> findBooksByAuthors(Author author);

    List<Book> findBooksByPublisher(Publisher publisher);

    List<Book> findBooksByRating(int rating);

    Optional<Book> findFirstBookByCategoryOrderByTitle(Category category);

    @Query("SELECT b FROM books b WHERE b.title = ?1")
    Optional<Book> findBookByTitleQuery(String title);

    @Query("SELECT b FROM books b WHERE b.category = ?1")
    List<Book> findBooksByCategoryQuery(Category category);

    @Query("SELECT b FROM books b WHERE b.rating BETWEEN ?1 AND ?2")
    List<Book> findBooksByRatingBetweenQuery(int rating1, int rating2);

    @Query("SELECT b FROM books b WHERE b.publisher = :publisher")
    List<Book> findBooksByPublisherQuery(@Param("publisher") Publisher publisher);

    @Query("SELECT b FROM books b WHERE b.category = :category ORDER BY b.title")
    List<Book> findBooksByCategoryOrderByTitleQuery(@Param("category") Category category);
}
