package org.epam.service;

import org.epam.dao.BookRepository;
import org.epam.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<Book> findAll(){
        return bookRepository.findAll();
    }
    public Book save(Book book){
        return bookRepository.save(book);
    }
}
