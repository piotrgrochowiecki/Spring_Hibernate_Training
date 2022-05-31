package com.piotrgrochowiecki.bookstore.controller;

import com.piotrgrochowiecki.bookstore.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
@Controller
@RequestMapping("student")
public class StudentController {

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("Python", "Java", "Go", ".NET", "COBOL");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("Skiing", "Sailing", "Cycling", "Trekking", "Running");
    }

    @RequestMapping("addByForm")
    public String returnView() {
        return "student-form";
    }

    @PostMapping("addByForm")
    @ResponseBody
    public String create(Model model) {
        model.addAttribute("student", new Student());
        return "Thank you";
    }
}
