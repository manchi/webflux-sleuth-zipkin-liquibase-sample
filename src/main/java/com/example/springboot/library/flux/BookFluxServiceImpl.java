package com.example.springboot.library.flux;

import java.time.Duration;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.springboot.library.model.Book;
import com.example.springboot.library.repository.LibraryRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@Slf4j
public class BookFluxServiceImpl implements BookFluxService {

    final LibraryRepository libraryRepository;

    public BookFluxServiceImpl(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @Override
    public Mono<Book> save(Book book) {
        return null;
    }

    @Override
    public Mono<Book> findById(Long id) {
        return null;
    }

    @Override
    public Flux<Book> findAll() {
        log.info("in flux findAll method");
        return Flux.fromIterable(libraryRepository.findAll())
            .delayElements(Duration.ofMillis(50))
            .limitRate(100)
            .take(100);
    }

    @Override
    public Mono<Book> deleteById(Long id) {
        return null;
    }
}