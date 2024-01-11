package ru.otus.nosqldb.stringifier.impl;

import org.springframework.stereotype.Component;
import ru.otus.nosqldb.model.Genre;
import ru.otus.nosqldb.stringifier.GenreStringifier;

@Component
public class GenreStringifierImpl implements GenreStringifier {
    @Override
    public String stringify(Genre genre) {
        return "Genre(id=" + genre.getId() + ", genreName=" + genre.getName() + ")";
    }
}
