package ru.otus.datajpa.stringifier.impl;

import org.springframework.stereotype.Component;
import ru.otus.datajpa.model.Genre;
import ru.otus.datajpa.stringifier.GenreStringifier;

@Component
public class GenreStringifierImpl implements GenreStringifier {
    @Override
    public String stringify(Genre genre) {
        return "Genre(id=" + genre.getId() + ", genreName=" + genre.getName() + ")";
    }
}
