package com.femsa.digital.backend.infra.bd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.femsa.digital.backend.infra.bd.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
