package ru.otus.jpahibernate.stringifier;

import ru.otus.jpahibernate.model.Genre;

public interface GenreStringifier {
    String stringify(Genre genre);
}
