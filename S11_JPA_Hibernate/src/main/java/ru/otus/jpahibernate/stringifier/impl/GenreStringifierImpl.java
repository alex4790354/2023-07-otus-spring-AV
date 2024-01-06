package ru.otus.jpahibernate.stringifier.impl;

import org.springframework.stereotype.Component;
import ru.otus.jpahibernate.model.Genre;
import ru.otus.jpahibernate.stringifier.GenreStringifier;

@Component
public class GenreStringifierImpl implements GenreStringifier {
    @Override
    public String stringify(Genre genre) {
        return "Genre(id=" + genre.getId() + ", genreName=" + genre.getName() + ")";
    }
}
