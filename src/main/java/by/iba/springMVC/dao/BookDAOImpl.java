package by.iba.springMVC.dao;

import by.iba.springMVC.entity.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by DarchykM on 28.08.2017.
 */
@Repository
public class BookDAOImpl implements BookDAO{

    @PersistenceContext
    EntityManager entityManager;

    public List<Book> getBooks() {
        return entityManager.createQuery("SELECT b FROM Book b").getResultList();
    }

    public void addBook(Book book) {
        entityManager.persist(book);
    }

    public Book getBook(Integer id) {
        return entityManager.find(Book.class, id);
    }

    public void deleteBook(Integer id) {
        entityManager.remove(getBook(id));
    }

    public void updateBook(Book book) {
        entityManager.merge(book);
    }

}
