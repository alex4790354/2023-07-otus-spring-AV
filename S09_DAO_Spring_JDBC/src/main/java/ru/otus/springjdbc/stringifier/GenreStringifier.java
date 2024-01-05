package ru.otus.springjdbc.stringifier;

import ru.otus.springjdbc.model.Genre;

public interface GenreStringifier {
    String stringify(Genre genre);
}
