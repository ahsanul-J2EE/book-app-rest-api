package com.bookapp.book.app.rest.api.repositories;

import com.bookapp.book.app.rest.api.entity.Book;
import com.bookapp.book.app.rest.api.entity.User;
import com.bookapp.book.app.rest.api.models.BookDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepo extends JpaRepository<Book, Integer> {

    List<Book> findAllByAuthorName(String authorName);

    Optional<Book> findByBookNameAndAuthorName(String authorName, String bookName);


}
