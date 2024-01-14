package ru.otus.security.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.security.exception.NotFoundException;
import ru.otus.security.model.Comment;
import ru.otus.security.repository.BookRepository;
import ru.otus.security.repository.CommentRepository;
import ru.otus.security.service.CommentService;
import ru.otus.security.util.ErrorMessage;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final BookRepository bookRepository;

    private final CommentRepository commentRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Comment> getAllByBookId(long bookId) {
        var book = bookRepository.findById(bookId)
                .orElseThrow(() ->
                        new NotFoundException(format(ErrorMessage.BOOK_NOT_FOUND, bookId)));
        return commentRepository.findAllByBook(book);
    }

}
