package ru.otus.nosqldb.stringifier;

import ru.otus.nosqldb.model.Genre;

public interface GenreStringifier {
    String stringify(Genre genre);
}
