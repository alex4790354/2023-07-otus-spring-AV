package ru.otus.springjdbc.stringifier;

import ru.otus.springjdbc.model.Author;

public interface AuthorStringifier {
    String stringify(Author author);
}
