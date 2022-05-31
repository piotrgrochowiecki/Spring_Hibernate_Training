package com.piotrgrochowiecki.bookstore.controller;

import com.piotrgrochowiecki.bookstore.model.Student;
import com.piotrgrochowiecki.bookstore.model.StudentHobby;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
    public Collection<StudentHobby> hobbies() {
        List<StudentHobby> studentHobbyList = new ArrayList<>();
        studentHobbyList.add(new StudentHobby(1, "skiing"));
        studentHobbyList.add(new StudentHobby(2, "cycling"));
        studentHobbyList.add(new StudentHobby(3, "sailing"));
        return studentHobbyList;
    }

    @GetMapping("addByForm")
    public String showStudentAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "/student-form.jsp";
    }

    @PostMapping("addByForm")
    @ResponseBody
    public String create(Student student) {
        return "Typed student is: " + student.toString();
    }
}
