package by.iba.springMVC.controller;

import by.iba.springMVC.entity.Book;
import by.iba.springMVC.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by DarchykM on 28.08.2017.
 */

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/")
    public ModelAndView getAllBooks(ModelAndView model){
        model.addObject("allBooks", bookService.getBooks());
        model.setViewName("home");
        return model;
    }

    @RequestMapping(value = "/newBook", method = RequestMethod.GET)
    public ModelAndView addBook(ModelAndView model) {
        Book book = new Book();
        model.addObject("book", book);
        model.setViewName("bookForm");
        return model;
    }

    @RequestMapping(value = "/saveBook", method = RequestMethod.POST)
    public ModelAndView saveBook(@ModelAttribute Book book) {
        if (book.getId() == 0) {
            bookService.addBook(book);
        } else {
            bookService.updateBook(book);
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
    public ModelAndView deleteBook(HttpServletRequest request) {
        int bookId = Integer.parseInt(request.getParameter("id"));
        bookService.deleteBook(bookId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/editBook", method = RequestMethod.GET)
    public ModelAndView editBook(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.getBook(employeeId);
        ModelAndView model = new ModelAndView("bookForm");
        model.addObject("book", book);
        return model;
    }

}
