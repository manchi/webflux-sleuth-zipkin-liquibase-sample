package com.example.springboot.library.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.springboot.library.model.Book;
import com.example.springboot.library.repository.LibraryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class BookServiceImpl implements BookService {

    final LibraryRepository libraryRepository;

    public BookServiceImpl(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public Book findById(Long id) {
        return null;
    }

    @Override
    public List<Book> findByTitleContaining(String title) {
        log.info("in service impl - findByTitleContaining: {}", title);

        Iterable<Book> all = libraryRepository.findByTitleContaining(title);
        List<Book> list = StreamSupport.stream(all.spliterator(), false)
            .collect(Collectors.toList());

        return list;
    }

    @Override
    public List<Book> findByAuthorContaining(String author) {
        log.info("in service impl - findByAuthorContaining: {}", author);

        Iterable<Book> all = libraryRepository.findByAuthorContaining(author);
        List<Book> list = StreamSupport.stream(all.spliterator(), false)
            .collect(Collectors.toList());

        return list;
    }

    @Override
    public List<Book> findByPublished(boolean published) {
        log.info("in service impl - findByPublished: {}", published);

        Iterable<Book> all = libraryRepository.findByPublished(published);
        List<Book> list = StreamSupport.stream(all.spliterator(), false)
            .limit(100)
            .collect(Collectors.toList());

        return list;
    }

    @Override
    public List<Book> findAll() {

        Iterable<Book> all = libraryRepository.findAll();

        List<Book> list = StreamSupport.stream(all.spliterator(), false)
            .collect(Collectors.toList());

        return list;
    }

    @Override
    public Book deleteById(Long id) {
        return null;
    }
}