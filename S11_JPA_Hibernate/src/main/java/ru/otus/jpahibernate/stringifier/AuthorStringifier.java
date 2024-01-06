package ru.otus.jpahibernate.stringifier;

import ru.otus.jpahibernate.model.Author;

public interface AuthorStringifier {
    String stringify(Author author);
}
