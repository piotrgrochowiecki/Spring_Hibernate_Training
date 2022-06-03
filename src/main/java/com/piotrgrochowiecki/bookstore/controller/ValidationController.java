package com.piotrgrochowiecki.bookstore.controller;

import com.piotrgrochowiecki.bookstore.model.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;


@Slf4j
@Controller
@RequiredArgsConstructor
public class ValidationController {

    private final Validator validator;

    @GetMapping("/validate")
    public String validateObject(Model model) {
        Book book = new Book();
        book.setTitle("ar");
        book.setRating(23);
        book.setRating(-2575);
        Set<ConstraintViolation<Book>> result = validator.validate(book);
        if (!result.isEmpty()) {
            for (ConstraintViolation<Book> violation : result) {
                log.info("{} -> {}", violation.getPropertyPath(), violation.getMessage());
            }
        }
        model.addAttribute("book", book);
        model.addAttribute("errors", result);
        return "/bookValidationResultsView.jsp";
    }
}
