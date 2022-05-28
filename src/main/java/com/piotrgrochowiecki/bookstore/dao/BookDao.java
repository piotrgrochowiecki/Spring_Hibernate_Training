package com.piotrgrochowiecki.bookstore.dao;

import com.piotrgrochowiecki.bookstore.model.Author;
import com.piotrgrochowiecki.bookstore.model.Book;
import com.piotrgrochowiecki.bookstore.model.Publisher;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Book book) {
        entityManager.persist(book);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
    }

    public List<Book> findAll() {
        Query query = entityManager.createQuery("SELECT b FROM com.piotrgrochowiecki.bookstore.model.Book b", Book.class);
        return query.getResultList();
    }

    public List<Book> findAllByRating(int rating) {
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.rating = :rating");
        query.setParameter("rating", rating);
        List<Book> bookList = query.getResultList();
        return bookList;
    }

    public List<Book> findBookWithAnyPublisher() {
        Query query = entityManager.createQuery("SELECT b FROM Book b JOIN b.publisher");
        return query.getResultList();
    }

    public List<Book> findBookWithPublisher(Publisher publisher) {
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.publisher in :publishers");
        query.setParameter("publishers", publisher);
        return query.getResultList();
    }

    public List<Book> findBookWithAuthor(Author author) {
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.publisher in :authors");
        query.setParameter("authors", author);
        return query.getResultList();
    }
}
