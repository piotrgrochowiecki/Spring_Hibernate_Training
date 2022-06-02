package com.piotrgrochowiecki.bookstore.dao;

import com.piotrgrochowiecki.bookstore.model.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Author author) {
        entityManager.persist(author);
    }

    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }

    public void update(Author author) {
        entityManager.merge(author);
    }

    public void delete(Author author) {
        entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author));
    }

    public List<Author> findAll() {
        Query query = entityManager.createQuery("SELECT a FROM com.piotrgrochowiecki.bookstore.model.Author a", Author.class);
        return query.getResultList();
    }
}
