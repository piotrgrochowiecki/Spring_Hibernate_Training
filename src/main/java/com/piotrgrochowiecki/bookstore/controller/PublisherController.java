package com.piotrgrochowiecki.bookstore.controller;

import com.piotrgrochowiecki.bookstore.dao.PublisherDao;
import com.piotrgrochowiecki.bookstore.model.Publisher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("publishers/")
public class PublisherController {

    private final PublisherDao publisherDao;

    @GetMapping("/add")
    @ResponseBody
    public String add() {
        Publisher publisher = new Publisher();
        publisher.setName("Publishing house ABC");
        publisherDao.save(publisher);
        return "New publisher with id " + publisher.getId() + " has been added.";
    }

    @GetMapping("/show/{id}")
    @ResponseBody
    public String show(@PathVariable long id) {
        return publisherDao.findById(id).toString();
    }

    @GetMapping("/updateName/{id}/{name}")
    @ResponseBody
    public String updateName(@PathVariable long id, @PathVariable String name) {
        Publisher publisher = publisherDao.findById(id);
        publisher.setName(name);
        publisherDao.update(publisher);
        return "Publisher " + publisher.getName() + " has been updated";
    }

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Publisher> publisherList = publisherDao.findAll();
        model.addAttribute("publisherList", publisherList);
        return "/publisherListView.jsp";
    }

    @GetMapping("/deleteConfirmation/{id}")
    public String deleteConfirmation(@PathVariable Long id, Model model) {
        Publisher publisher = publisherDao.findById(id);
        model.addAttribute("publisher", publisher);
        return "/publisherDeleteConfirmationView.jsp";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Publisher publisher = publisherDao.findById(id);
        model.addAttribute("publisher", publisher);
        return "/publisherEditView.jsp";
    }

    @PostMapping("/editConfirmation")
    public String editHandle(@ModelAttribute("publisher") @Valid Publisher publisher, BindingResult result) {
        if (result.hasErrors()) {
            return "/publisherEditView.jsp";
        }
        publisherDao.update(publisher);
        return "redirect:/publishers/findAll";
    }
    
    @GetMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.delete(publisher);
        return "Publisher with id " + id + " has been deleted";
    }

}
