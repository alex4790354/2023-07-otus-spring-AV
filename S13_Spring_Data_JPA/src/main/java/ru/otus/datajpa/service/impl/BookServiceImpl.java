package ru.otus.datajpa.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.datajpa.dto.BookDto;
import ru.otus.datajpa.exception.NotFoundException;
import ru.otus.datajpa.mapper.BookMapper;
import ru.otus.datajpa.model.Book;
import ru.otus.datajpa.repository.AuthorRepository;
import ru.otus.datajpa.repository.BookRepository;
import ru.otus.datajpa.repository.GenreRepository;
import ru.otus.datajpa.service.BookService;
import ru.otus.datajpa.utils.ErrorMessage;

import java.util.List;

import static java.lang.String.format;


@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final GenreRepository genreRepository;

    private final AuthorRepository authorRepository;

    @Transactional(readOnly = true)
    @Override
    public long getCount() {
        return bookRepository.count();
    }

    @Transactional
    @Override
    public Book create(BookDto bookDto) {
        var genre = genreRepository.findById(bookDto.getGenreId())
                .orElseThrow(() -> new NotFoundException(
                        String.format(ErrorMessage.GENRE_NOT_FOUND, bookDto.getGenreId())
                ));

        var author = authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new NotFoundException(
                        String.format(ErrorMessage.AUTHOR_NOT_FOUND, bookDto.getAuthorId())
                ));

        var book = BookMapper.mapDtoToBook(bookDto, genre, author);
        return bookRepository.save(book);
    }

    @Transactional
    public Book update(BookDto bookDto) {
        var genre = genreRepository.findById(bookDto.getGenreId()).orElseThrow(() -> new NotFoundException(
                        String.format(ErrorMessage.GENRE_NOT_FOUND, bookDto.getGenreId())
                ));

        var author = authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new NotFoundException(
                        String.format(ErrorMessage.AUTHOR_NOT_FOUND, bookDto.getAuthorId())
                ));

        bookRepository.findById(bookDto.getId())
                .orElseThrow(() -> new NotFoundException(
                        String.format(ErrorMessage.BOOK_NOT_FOUND, bookDto.getId())
                ));

        return BookMapper.mapDtoToBook(bookDto, genre, author);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getAll(Sort sort) {
        return bookRepository.findAll(sort);
    }

    @Override
    public Book getById(long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(format(ErrorMessage.BOOK_NOT_FOUND, id)));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getAllByGenreId(long id) {
        var genre = genreRepository.findById(id).orElseThrow(() -> new NotFoundException(
                        String.format(ErrorMessage.GENRE_NOT_FOUND, id)));
        return bookRepository.findAllByGenreId(genre.getId());
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getAllByAuthorId(long id) {
        var author = authorRepository.findById(id).orElseThrow(() ->
                        new NotFoundException(String.format(ErrorMessage.AUTHOR_NOT_FOUND, id)));
        return bookRepository.findAllByAuthorId(author.getId());
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public void deleteAll() {
        bookRepository.deleteAll();
    }
}
