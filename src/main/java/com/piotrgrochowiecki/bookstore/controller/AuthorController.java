package com.piotrgrochowiecki.bookstore.controller;

import com.piotrgrochowiecki.bookstore.dao.AuthorDao;
import com.piotrgrochowiecki.bookstore.model.Author;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("authors/")
@AllArgsConstructor
public class AuthorController {

    private final AuthorDao authorDao;

    @GetMapping("/add")
    @ResponseBody
    public String add() {
        Author author = new Author();
        author.setFirstName("Bruce");
        author.setLastName("Eckel");
        authorDao.save(author);
        return "New author with id " + author.getId() + " has been added.";
    }

    @GetMapping("/show/{id}")
    @ResponseBody
    public String show(@PathVariable long id) {
        return authorDao.findById(id).toString();
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable long id) {
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "Author with id " + id + " has been deleted";
    }

    @GetMapping("/updateFirstName/{id}/{firstName}")
    @ResponseBody
    public String updateFirstName(@PathVariable long id, @PathVariable String firstName) {
        Author author = authorDao.findById(id);
        author.setFirstName(firstName);
        authorDao.update(author);
        return "Author with id " + author.getId() + " has been updated";
    }
}
