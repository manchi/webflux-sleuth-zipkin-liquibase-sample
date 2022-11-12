package com.example.springboot.library.controller;

import java.time.Duration;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.library.flux.BookFluxService;
import com.example.springboot.library.model.Book;
import com.example.springboot.library.service.BookService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("books")
@Slf4j
public class BookControllerV2 {

    BookService bookService;
    BookFluxService bookFluxService;

    public BookControllerV2(BookService bookService, BookFluxService bookFluxService) {
        this.bookService = bookService;
        this.bookFluxService = bookFluxService;
    }

    @GetMapping(value = "/v2/title/{title}", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Book> getByBookTitle(@PathVariable(required = false) String title) {
        log.info("getByBookTitle:: {}", title);

        List<Book> list = bookService.findByTitleContaining(title);
        return Flux.fromIterable(list)
            .limitRate(10)
            .delayElements(Duration.ofMillis(100))
            .take(100)
            .log();

    }

    @GetMapping(value = "/v2/author/{author}", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Book> getByBookAuthor(@PathVariable(required = false) String author) {
        log.info("getByBookAuthor:: {}", author);

        List<Book> list = bookService.findByAuthorContaining(author);

        return Flux.fromIterable(list)
            .limitRate(10)
            .delayElements(Duration.ofMillis(100))
            .take(100)
            .log();

    }

    @GetMapping(value = "/v2/published", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Book> findByPublished() {

        log.info("findByPublished:: started");
        List<Book> list = bookService.findByPublished(true);

        return Flux.fromIterable(list)
            .limitRate(10)
            .delayElements(Duration.ofMillis(100))
            .take(100)
            .log();
    }

    @RequestMapping(path = "/v2/flux", method = RequestMethod.GET, produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Book> getAllBooksUsingFlux() {
        log.info("getAllBooksUsingFlux:: started");
        return bookFluxService.findAll();
    }

    @GetMapping(value = "/v2", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Book> getAllBooks() {

        List<Book> list = bookService.findAll();
        log.info("total records: {}", list.size());

        return Flux.fromIterable(list)
            .limitRate(10)
            .delayElements(Duration.ofMillis(100))
            .take(100)
            .log();
    }
}