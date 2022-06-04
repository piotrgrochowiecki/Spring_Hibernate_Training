package com.piotrgrochowiecki.bookstore.repository;

import com.piotrgrochowiecki.bookstore.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    Optional<Publisher> findByNip(String nip);

    Optional<Publisher> findByRegon(String regon);


}
