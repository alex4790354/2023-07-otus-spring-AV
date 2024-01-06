package ru.otus.datajpa.stringifier.impl;

import org.springframework.stereotype.Component;
import ru.otus.datajpa.model.Author;
import ru.otus.datajpa.stringifier.AuthorStringifier;

@Component
public class AuthorStringifierImpl implements AuthorStringifier {

    @Override
    public String stringify(Author author) {
        return "Author(id=" + author.getId() + ", name=" + author.getName() + ")";
    }
}
