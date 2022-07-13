package com.restapi.tutorial.Books;

import java.util.Optional;

public interface BookService {
    Iterable<Book> findAllBook();

    Optional<Book> findBookbyId(long id);

    Book addBook(Book b);

    void deleteAllData();

    Book updateBook(long id, Book b);

    public void deleteById(long id);
}
