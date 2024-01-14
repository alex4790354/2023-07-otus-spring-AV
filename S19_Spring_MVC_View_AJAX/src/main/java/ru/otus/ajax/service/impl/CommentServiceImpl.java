package ru.otus.ajax.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.ajax.dto.CommentDto;
import ru.otus.ajax.exception.NotFoundException;
import ru.otus.ajax.mapper.CommentMapper;
import ru.otus.ajax.repository.BookRepository;
import ru.otus.ajax.repository.CommentRepository;
import ru.otus.ajax.service.CommentService;
import ru.otus.ajax.util.ErrorMessage;

import java.util.List;

import static java.lang.String.format;


@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final BookRepository bookRepository;

    private final CommentRepository commentRepository;


    @Transactional(readOnly = true)
    @Override
    public List<CommentDto> getAllByBookId(long bookId) {
        var book = bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException(format(ErrorMessage.BOOK_NOT_FOUND, bookId)));
        return commentRepository.findAllByBook(book)
                .stream()
                .map(CommentMapper::mapCommentToDto)
                .toList();
    }
}
