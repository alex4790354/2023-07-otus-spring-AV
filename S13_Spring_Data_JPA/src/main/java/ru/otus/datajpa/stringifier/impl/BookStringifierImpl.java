package ru.otus.datajpa.stringifier.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.datajpa.model.Book;
import ru.otus.datajpa.stringifier.AuthorStringifier;
import ru.otus.datajpa.stringifier.BookStringifier;
import ru.otus.datajpa.stringifier.GenreStringifier;

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
