package com.example.springboot.library.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springboot.library.model.Book;

@Repository
public interface LibraryRepository extends CrudRepository<Book, Long> {

    @Query(value = "SELECT b FROM Book b WHERE b.published = :published")
    List<Book> findByPublished(@Param(value = "published") boolean published);

    @Query(value = "SELECT b FROM Book b WHERE b.title LIKE  CONCAT('%',:title,'%')")
    List<Book> findByTitleContaining(String title);

    // similar to "SELECT b FROM Book b WHERE b.title LIKE  CONCAT('%',:title,'%')"
    List<Book> findByAuthorContaining(String author);

}

/*
 Using Like: select ... like :username
 List<User> findByUsernameLike(String username);

 StartingWith: select ... like :username%
 List<User> findByUsernameStartingWith(String username);

 EndingWith: select ... like %:username
 List<User> findByUsernameEndingWith(String username);

 Containing: select ... like %:username%
 List<User> findByUsernameContaining(String username);
 */