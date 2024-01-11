package ru.otus.nosqldb.stringifier;

import ru.otus.nosqldb.model.Book;

public interface BookStringifier {
    String stringify(Book book);
}
