package com.piotrgrochowiecki.bookstore.converter;

import com.piotrgrochowiecki.bookstore.dao.AuthorDao;
import com.piotrgrochowiecki.bookstore.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public Author convert(String source) {
        return authorDao.findById(Integer.parseInt(source));
    }
}
