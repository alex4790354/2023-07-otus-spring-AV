package ru.otus.nosqldb.stringifier.impl;

import org.springframework.stereotype.Component;
import ru.otus.nosqldb.model.Author;
import ru.otus.nosqldb.stringifier.AuthorStringifier;

@Component
public class AuthorStringifierImpl implements AuthorStringifier {

    @Override
    public String stringify(Author author) {
        return "Author(id=" + author.getId() + ", name=" + author.getName() + ")";
    }
}
