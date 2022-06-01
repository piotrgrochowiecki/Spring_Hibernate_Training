package com.piotrgrochowiecki.bookstore.controller;

import com.piotrgrochowiecki.bookstore.dao.AuthorDao;
import com.piotrgrochowiecki.bookstore.dao.BookDao;
import com.piotrgrochowiecki.bookstore.dao.PublisherDao;
import com.piotrgrochowiecki.bookstore.model.Author;
import com.piotrgrochowiecki.bookstore.model.Book;
import com.piotrgrochowiecki.bookstore.model.Publisher;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/books/")
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    @GetMapping("add/{firstAuthorId}/{secondAuthorId}")
    @ResponseBody
    public String add(@PathVariable long firstAuthorId, @PathVariable long secondAuthorId){
        Book book = new Book();
        book.setTitle("The Pragmatic Programmer");
        book.setRating(8);
        book.setDescription("From Journeyman to Master is a book about computer programming and software engineering, " +
                "written by Andrew Hunt and David Thomas and published in October 1999. It is used as a textbook in" +
                " related university courses.");

        Publisher publisher = new Publisher();
        publisher.setName("Publishing house GHI");
        publisherDao.save(publisher);
        book.setPublisher(publisher);

        Author author1 = authorDao.findById(firstAuthorId);
        Author author2 = authorDao.findById(secondAuthorId);
        List<Author> authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);
        book.setAuthors(authors);

        bookDao.save(book);
        return "Id of added book is " + book.getId();
    }

    @GetMapping("/show/{id}")
    @ResponseBody
    public String show(@PathVariable long id) {
        return bookDao.findById(id).toString();
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "Book with id " + id + " has been deleted";
    }

    @GetMapping("updateTitle/{id}/{title}")
    @ResponseBody
    public String updateTitle(@PathVariable long id, @PathVariable String title) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        bookDao.update(book);
        return "Title of the book with id " + id + " has been updated";
    }

    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<Book> bookList = bookDao.findAll();
        model.addAttribute("bookList", bookList);
        return "/bookListView.jsp";
    }

    @GetMapping("/findByRating/{rating}")
    @ResponseBody
    public String findByRating(@PathVariable int rating) {
        List<Book> bookList = bookDao.findAllByRating(rating);
        bookList.forEach(System.out::println);
        return "findByRating";
    }

    @GetMapping("/deleteConfirmation/{id}")
    public String deleteConfirmation(@PathVariable Long id, Model model) {
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);
        return "/bookDeleteConfirmationView.jsp";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);
        return "/bookEditView.jsp";
    }

    @ModelAttribute("publishers")
    public Collection<Publisher> publishers() {
        return this.publisherDao.findAll();
    }

    @PostMapping("/editConfirmation")
    @ResponseBody
    public String editHandle(@ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "Something went wrong!";
        }
        bookDao.update(book);
        return "Book has been updated!";
    }

}
