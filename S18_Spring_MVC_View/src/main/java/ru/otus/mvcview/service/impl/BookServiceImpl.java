package ru.otus.mvcview.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.mvcview.dto.BookCreateDto;
import ru.otus.mvcview.dto.BookDto;
import ru.otus.mvcview.dto.BookUpdateDto;
import ru.otus.mvcview.exception.NotFoundException;
import ru.otus.mvcview.mapper.BookMapper;
import ru.otus.mvcview.model.Book;
import ru.otus.mvcview.repository.AuthorRepository;
import ru.otus.mvcview.repository.BookRepository;
import ru.otus.mvcview.repository.GenreRepository;
import ru.otus.mvcview.service.BookService;
import ru.otus.mvcview.utils.ErrorMessage;

import java.util.List;

import static java.lang.String.format;


@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final GenreRepository genreRepository;

    private final AuthorRepository authorRepository;


    @Transactional
    @Override
    public BookDto create(BookCreateDto bookCreateDto) {
        var genre = genreRepository.findById(bookCreateDto.getGenreId())
                .orElseThrow(() -> new NotFoundException(
                        String.format(ErrorMessage.GENRE_NOT_FOUND, bookCreateDto.getGenreId())
                ));

        var author = authorRepository.findById(bookCreateDto.getAuthorId())
                .orElseThrow(() -> new NotFoundException(
                        String.format(ErrorMessage.AUTHOR_NOT_FOUND, bookCreateDto.getAuthorId())
                ));

        var book = bookRepository.save(BookMapper.mapDtoToNewBook(bookCreateDto, genre, author));

        return BookMapper.mapBookToDto(book);
    }

    @Transactional
    @Override
    public Book update(BookUpdateDto bookUpdateDto) {
        var genre = genreRepository.findById(bookUpdateDto.getGenreId()).orElseThrow(() -> new NotFoundException(
                String.format(ErrorMessage.GENRE_NOT_FOUND, bookUpdateDto.getGenreId())
        ));

        var author = authorRepository.findById(bookUpdateDto.getAuthorId())
                .orElseThrow(() -> new NotFoundException(
                        String.format(ErrorMessage.AUTHOR_NOT_FOUND, bookUpdateDto.getAuthorId())
                ));

        var book = bookRepository.findById(bookUpdateDto.getId())
                .orElseThrow(() -> new NotFoundException(
                        String.format(ErrorMessage.BOOK_NOT_FOUND, bookUpdateDto.getId())
                ));

        book.setTitle(bookUpdateDto.getTitle());
        book.setGenre(genre);
        book.setAuthor(author);

        return book;
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
    public List<Book> getAllByGenreId(long genreId) {
        var genre = genreRepository.findById(genreId).orElseThrow(() -> new NotFoundException(
                        String.format(ErrorMessage.GENRE_NOT_FOUND, genreId)));
        return bookRepository.findAllByGenreId(genre.getId());
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getAllByAuthorId(long authorId) {
        var author = authorRepository.findById(authorId).orElseThrow(() ->
                        new NotFoundException(String.format(ErrorMessage.AUTHOR_NOT_FOUND, authorId)));
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
