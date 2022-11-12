package com.example.springboot.library.flux;

import com.example.springboot.library.model.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookFluxService {

    Mono<Book> save(Book book);

    Mono<Book> findById(Long id);

    Flux<Book> findAll();

    Mono<Book> deleteById(Long id);

}
