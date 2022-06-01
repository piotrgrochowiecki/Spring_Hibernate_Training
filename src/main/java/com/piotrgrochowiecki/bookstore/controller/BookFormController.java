package com.piotrgrochowiecki.bookstore.controller;

import com.piotrgrochowiecki.bookstore.dao.BookDao;
import com.piotrgrochowiecki.bookstore.dao.PublisherDao;
import com.piotrgrochowiecki.bookstore.model.Book;
import com.piotrgrochowiecki.bookstore.model.Publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
@RequiredArgsConstructor
public class BookFormController {

    private final PublisherDao publisherDao;
    private final BookDao bookDao;

    @GetMapping("addBookByForm")
    public String addBookByForm(Model model) {
        model.addAttribute("book", new Book());
        return "/addBookForm.jsp";
    }

    @ModelAttribute("publishers")
    public Collection<Publisher> publishers() {
        return this.publisherDao.findAll();
    }

    @PostMapping("addBookByForm")
    public String addBookByFormHandle(@ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "There has been an error! Go back and try again";
        }
        bookDao.save(book);
        return "redirect:/books/findAll";
    }

}
