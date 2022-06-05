package com.piotrgrochowiecki.bookstore.dao;

import com.piotrgrochowiecki.bookstore.model.Author;
import com.piotrgrochowiecki.bookstore.model.Book;
import com.piotrgrochowiecki.bookstore.model.Category;
import com.piotrgrochowiecki.bookstore.repository.AuthorRepository;
import com.piotrgrochowiecki.bookstore.repository.BookRepository;
import com.piotrgrochowiecki.bookstore.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("springDataTest/book/")
@RequiredArgsConstructor
public class SpringDataBookController {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;

    @GetMapping("findAll")
    public String findAll() {
        List<Book> books = bookRepository.findAll();
        books.forEach(book -> log.info("{}", book.getId()));
        return books.toString();
    }

    @GetMapping("findBookByTitle/{title}")
    public String findBookByTitle(@PathVariable String title) {
        Optional<Book> book = bookRepository.findBookByTitle(title);
        return book.toString();
    }

    @GetMapping("findBooksByCategory/{categoryName}")
    public String findBookByCategory(@PathVariable String categoryName) {
        Optional<Category> category = categoryRepository.findCategoryByName(categoryName);
        List<Book> books = bookRepository.findBooksByCategory(category.get());
        return books.toString();
    }

    @GetMapping("findBooksByCategoryId/{id}")
    public String findBooksByCategoryId(@PathVariable int id) {
        Optional<Category> category = categoryRepository.findCategoryById((long) id);
        List<Book> books = bookRepository.findBooksByCategoryId(category.get().getId());
        return books.toString();
    }

    @GetMapping("findBooksByAuthor/{lastName}")
    public String findBooksByAuthor(@PathVariable String lastName) {
        List<Author> authors = authorRepository.findAuthorsByLastName(lastName);
        Author author = authors.get(0);
        List<Book> books = bookRepository.findBooksByAuthors(author);
        return books.toString();
    }

    @GetMapping("findBookByTitleQuery/{title}")
    public String findBookByTitleQuery(@PathVariable String title) {
        Optional<Book> book = bookRepository. findBookByTitleQuery(title);
        return book.toString();
    }
}
