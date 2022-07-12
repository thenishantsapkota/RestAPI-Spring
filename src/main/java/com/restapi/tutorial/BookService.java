package com.restapi.tutorial;

import java.util.HashSet;

public interface BookService {
    HashSet<Book> findAllBook();

    Book findBookbyId(long id);

    void addBook(Book b);

    void deleteAllData();
}
