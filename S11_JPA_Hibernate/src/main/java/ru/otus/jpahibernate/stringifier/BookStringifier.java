package ru.otus.jpahibernate.stringifier;

import ru.otus.jpahibernate.model.Book;

public interface BookStringifier {
    String stringify(Book book);
}
