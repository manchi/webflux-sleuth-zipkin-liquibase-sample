package com.example.springboot.library.service;

import java.util.List;

import com.example.springboot.library.model.Book;

public interface BookService {

    Book save(Book book);

    Book findById(Long id);

    List<Book> findAll();

    Book deleteById(Long id);

    List<Book> findByTitleContaining(String title);

    List<Book> findByAuthorContaining(String author);

    List<Book> findByPublished(boolean published);

}
