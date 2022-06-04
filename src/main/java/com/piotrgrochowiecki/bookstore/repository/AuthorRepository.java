package com.piotrgrochowiecki.bookstore.repository;

import com.piotrgrochowiecki.bookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findAuthorByEmail(String email);

    Optional<Author> findAuthorByPesel(String pesel);

    List<Author> findAuthorsByLastName(String lastName);

}
