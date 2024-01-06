package ru.otus.jpahibernate.stringifier.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.jpahibernate.model.Book;
import ru.otus.jpahibernate.stringifier.AuthorStringifier;
import ru.otus.jpahibernate.stringifier.BookStringifier;
import ru.otus.jpahibernate.stringifier.GenreStringifier;

@Component
@RequiredArgsConstructor
public class BookStringifierImpl implements BookStringifier {

    private final GenreStringifier genreStringifier;

    private final AuthorStringifier authorStringifier;

    @Override
    public String stringify(Book book) {
        return "Book(id=" + book.getId() + ", title=" + book.getTitle() +
                ", genre=" + genreStringifier.stringify(book.getGenre()) +
                ", author=" + authorStringifier.stringify(book.getAuthor()) + ")";
    }
}
