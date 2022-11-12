package com.example.springboot.library.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.library.model.Book;

@Repository
public interface LibraryFluxRepository extends JpaRepository<Book, Long> {

}