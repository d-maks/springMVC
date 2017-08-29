package by.iba.springMVC.dao;

import by.iba.springMVC.entity.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getBooks();
    void addBook(Book book);
    Book getBook(Integer id);
    void deleteBook(Integer id);
    void updateBook(Book book);
}
