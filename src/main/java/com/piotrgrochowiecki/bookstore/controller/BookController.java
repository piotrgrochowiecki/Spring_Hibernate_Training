package com.piotrgrochowiecki.bookstore.controller;

import com.piotrgrochowiecki.bookstore.model.Book;
import com.piotrgrochowiecki.bookstore.repository.BookDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
@RequestMapping("/books/")
public class BookController {

    private final BookDao bookDao;

    @GetMapping("add")
    @ResponseBody
    public String add(){
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setRating(8);
        book.setDescription("Very good book for learning Java");
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

}
