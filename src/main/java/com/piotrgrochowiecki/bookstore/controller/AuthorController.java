package com.piotrgrochowiecki.bookstore.controller;

import com.piotrgrochowiecki.bookstore.dao.AuthorDao;
import com.piotrgrochowiecki.bookstore.model.Author;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Author> authorList = authorDao.findAll();
        model.addAttribute("authorList", authorList);
        return "/authorListView.jsp";
    }

    @GetMapping("/deleteConfirmation/{id}")
    public String deleteConfirmation(@PathVariable Long id, Model model) {
        Author author = authorDao.findById(id);
        model.addAttribute("author", author);
        return "/authorDeleteConfirmationView.jsp";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Author author = authorDao.findById(id);
        model.addAttribute("author", author);
        return "/authorEditView.jsp";
    }

    @PostMapping("/editConfirmation")
    public String editHandle(@ModelAttribute("author") @Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "/authorEditView.jsp";
        }
        authorDao.update(author);
        return "redirect:/authors/findAll";
    }

    @GetMapping("/show/{id}")
    @ResponseBody
    public String show(@PathVariable long id) {
        return authorDao.findById(id).toString();
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id) {
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "Author " + author.getFullName() + " has been deleted";
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
