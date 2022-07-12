package com.restapi.tutorial;

import java.util.HashSet;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    BookResponse bookResponse;

    @Autowired
    BookServiceImpl bookServiceImpl;

    @PostMapping("/api/books")
    public Map<String, Object> addBook(@RequestBody Book book) {
        try {
            bookServiceImpl.addBook(book);
            return bookResponse.successResponse("Book added successfully!", null);
        } catch (Exception e) {
            return bookResponse.errorResponse(e.toString());
        }
    }

    @GetMapping("/api/books")
    public Map<String, Object> getAllBooks() {
        try {
            HashSet<Book> b = bookServiceImpl.findAllBook();
            return bookResponse.successResponse("Books fetched successfully!", b);
        } catch (Exception e) {
            return bookResponse.errorResponse(e.toString());
        }
    }

    @GetMapping("/api/book/{id}")
    public Map<String, Object> getBookbyId(@PathVariable long id) {
        try {
            Book b = bookServiceImpl.findBookbyId(id);
            if (b == null)
                return bookResponse.errorResponse(String.format("No book with ID %s", id));
            return bookResponse.successResponse("Book fetched successfully!", b);
        } catch (Exception e) {
            return bookResponse.errorResponse(e.toString());
        }
    }

    @DeleteMapping("/api/books")
    public Map<String, Object> deleteAllBooks() {
        try {
            bookServiceImpl.deleteAllData();
            return bookResponse.successResponse("Books deleted successfully!", null);
        } catch (Exception e) {
            return bookResponse.errorResponse(e.toString());
        }
    }
}
