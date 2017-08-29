package by.iba.springMVC.service;

import by.iba.springMVC.dao.BookDAO;
import by.iba.springMVC.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookDAO bookDAO;

    @Transactional(readOnly = true)
    public List<Book> getBooks() {
        return bookDAO.getBooks();
    }

    @Transactional
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Transactional
    public Book getBook(Integer id) {
        return bookDAO.getBook(id);
    }

    @Transactional
    public void deleteBook(Integer id) {
        bookDAO.deleteBook(id);
    }

    @Transactional
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

}
