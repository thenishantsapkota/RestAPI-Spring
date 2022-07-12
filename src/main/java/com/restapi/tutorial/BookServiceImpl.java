package com.restapi.tutorial;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    HashSet<Book> bookList = new HashSet<Book>();

    @Autowired
    BookRepository bookRepository;

    @Override
    public Iterable<Book> findAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findBookbyId(long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book;
    }

    @Override
    public Book addBook(Book b) {
        return bookRepository.save(b);
    }

    @Override
    public Book updateBook(long id, Book b) {
        Optional<Book> book = bookRepository.findById(id);
        Book b1 = book.get();
        b1.setAuthor(b.getAuthor() == null ? b1.getAuthor() : b.getAuthor());
        b1.setName(b.getName() == null ? b1.getName() : b.getName());
        return bookRepository.save(b1);
    }

    @Override
    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

    
    
    @Override
    public void deleteAllData() {
        bookRepository.deleteAll();
    }
}
