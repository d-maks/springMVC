package by.iba.springMVC.service;

import by.iba.springMVC.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
    void addBook(Book book);
    Book getBook(Integer id);
    void deleteBook(Integer id);
    void updateBook(Book book);

}
