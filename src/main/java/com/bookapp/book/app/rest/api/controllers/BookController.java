package com.bookapp.book.app.rest.api.controllers;


import com.bookapp.book.app.rest.api.models.ApiResponse;
import com.bookapp.book.app.rest.api.models.BookDto;
import com.bookapp.book.app.rest.api.models.UserDto;
import com.bookapp.book.app.rest.api.services.BookService;
import com.bookapp.book.app.rest.api.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @PostMapping("/create")
    public ResponseEntity<BookDto> createUser(@Valid @RequestBody BookDto bookDto){
        BookDto createdBookDto = this.bookService.createBook(bookDto);
        return new ResponseEntity<>(createdBookDto, HttpStatus.CREATED);
    }

    @PutMapping("/update/{bookId}")
    public ResponseEntity<BookDto> updateBook(@Valid @RequestBody BookDto bookDto,@PathVariable Integer bookId){

        BookDto updatedBook =  this.bookService.updateBook(bookDto,bookId);

        return ResponseEntity.ok(updatedBook);

    }




    @DeleteMapping("delete/{bookId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer bookId){

        this.bookService.deleteBook(bookId);

        return new ResponseEntity(new ApiResponse("Book Deleted Successfully",true),HttpStatus.OK);

    }


    @GetMapping("/all")
    public ResponseEntity<List<BookDto>> getAllBooks(){
        System.out.println(this.bookService.getAllBooks());
        return ResponseEntity.ok(this.bookService.getAllBooks());
    }

    @GetMapping("/author/{author_name}")
    public ResponseEntity<List<BookDto>> getBooksByAuthor(@PathVariable String author_name) {

        return ResponseEntity.ok(this.bookService.getBooksByAutherName(author_name));
//        return bookRepository.findByAuthorName(authorName);
    }

    @GetMapping("/{author_name}/{book_name}")
    public ResponseEntity<BookDto> getBooksByAuthorAndBookName(@PathVariable String author_name,@PathVariable String book_name) {

        return ResponseEntity.ok(this.bookService.getBooksByAuthorAndBookName(author_name,book_name));

//        return ResponseEntity.ok(this.bookService.getBookById(bookId));
//        return bookRepository.findByAuthorName(authorName);
    }


    @GetMapping("/id/{bookId}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Integer bookId){
        return ResponseEntity.ok(this.bookService.getBookById(bookId));
    }


}
