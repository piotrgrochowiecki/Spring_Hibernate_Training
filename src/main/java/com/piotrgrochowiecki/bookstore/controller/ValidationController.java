package com.piotrgrochowiecki.bookstore.controller;

import com.piotrgrochowiecki.bookstore.model.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;


@RestController
@Slf4j
@RequiredArgsConstructor
public class ValidationController {

    private final Validator validator;

    @GetMapping("validate")
    public String validateObject(Model model) {
        Book book = new Book();
        Set<ConstraintViolation<Book>> result = validator.validate(book);
        if (!result.isEmpty()) {
            for (ConstraintViolation<Book> violation : result) {
                log.info("{} -> {}", violation.getPropertyPath(), violation.getMessage());
            }
        }
        model.addAttribute("errors", result);
        return "validate";
    }
}
