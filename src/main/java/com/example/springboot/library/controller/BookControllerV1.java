package com.example.springboot.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.library.flux.BookFluxService;
import com.example.springboot.library.model.Book;
import com.example.springboot.library.service.BookService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("books")
@Slf4j
public class BookControllerV1 {

    BookService repository;

    public BookControllerV1(BookService bookService, BookFluxService bookFluxService) {
        this.repository = bookService;
    }


    @GetMapping("v1/{id}")
    public ResponseEntity<Book> getTutorialById(@PathVariable("id") long id) {
        Optional<Book> data = Optional.ofNullable(repository.findById(id));
        if (data.isPresent()) {
            return new ResponseEntity<>(data.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        /*
        return data.map(book -> new ResponseEntity<>(book, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
         */
    }

    @PostMapping("v1/")
    public ResponseEntity<Book> createTutorial(@RequestBody Book tutorial) {
        try {
            Book _tutorial =
                repository.save(new Book(tutorial.getTitle(), tutorial.getAuthor(), false));
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("v1/published")
    public List<Book> findByPublished() {

        log.info("findByPublished:: started");
        return repository.findByPublished(true);
    }

    @PutMapping("v1/{id}")
    public ResponseEntity<Book> updateTutorial(@PathVariable("id") long id, @RequestBody Book tutorial) {
        Optional<Book> tutorialData = Optional.ofNullable(repository.findById(id));
        if (tutorialData.isPresent()) {
            Book _tutorial = tutorialData.get();
            _tutorial.setTitle(tutorial.getTitle());
            _tutorial.setAuthor(tutorial.getAuthor());
            _tutorial.setPublished(tutorial.isPublished());

            return new ResponseEntity<>(repository.save(_tutorial), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("v1/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            repository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}