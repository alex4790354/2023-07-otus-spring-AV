package ru.otus.nosqldb.stringifier;

import ru.otus.nosqldb.model.Author;

public interface AuthorStringifier {
    String stringify(Author author);
}
