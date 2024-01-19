package ru.otus.securityacl.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.securityacl.dto.CommentDto;
import ru.otus.securityacl.exception.NotFoundException;
import ru.otus.securityacl.mapper.CommentMapper;
import ru.otus.securityacl.repository.BookRepository;
import ru.otus.securityacl.repository.CommentRepository;
import ru.otus.securityacl.service.CommentService;
import ru.otus.securityacl.util.ErrorMessage;

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
