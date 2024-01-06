package ru.otus.jpahibernate.stringifier.impl;

import org.springframework.stereotype.Component;
import ru.otus.jpahibernate.model.Author;
import ru.otus.jpahibernate.stringifier.AuthorStringifier;

@Component
public class AuthorStringifierImpl implements AuthorStringifier {

    @Override
    public String stringify(Author author) {
        return "Author(id=" + author.getId() + ", name=" + author.getName() + ")";
    }
}
