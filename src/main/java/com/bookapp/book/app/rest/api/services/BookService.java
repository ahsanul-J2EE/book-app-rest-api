package com.bookapp.book.app.rest.api.services;

import com.bookapp.book.app.rest.api.models.BookDto;

import java.util.List;

public interface BookService {

    BookDto createBook(BookDto book);
    BookDto updateBook(BookDto book, Integer id);
    BookDto getBookById(Integer id);

    List<BookDto> getAllBooks();
    List<BookDto> getBooksByAutherName(String author_name);

    BookDto getBooksByAuthorAndBookName(String author_name,String book_name);

    void deleteBook (Integer bookId);
}
