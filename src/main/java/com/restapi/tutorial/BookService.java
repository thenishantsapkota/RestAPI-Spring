package com.restapi.tutorial;

import java.util.Optional;

public interface BookService {
    Iterable<Book> findAllBook();

    Optional<Book> findBookbyId(long id);

    Book addBook(Book b);

    void deleteAllData();
}
