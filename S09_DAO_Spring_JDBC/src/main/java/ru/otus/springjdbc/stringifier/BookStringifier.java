package ru.otus.springjdbc.stringifier;

import ru.otus.springjdbc.model.Book;

public interface BookStringifier {
    String stringify(Book book);
}
