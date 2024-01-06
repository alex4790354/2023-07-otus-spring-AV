package ru.otus.datajpa.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.datajpa.dto.CommentDto;
import ru.otus.datajpa.exception.NotFoundException;
import ru.otus.datajpa.mapper.CommentMapper;
import ru.otus.datajpa.model.Comment;
import ru.otus.datajpa.repository.BookRepository;
import ru.otus.datajpa.repository.CommentRepository;
import ru.otus.datajpa.service.CommentService;
import ru.otus.datajpa.utils.ErrorMessage;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final BookRepository bookRepository;

    private final CommentRepository commentRepository;

    @Transactional
    @Override
    public Comment create(CommentDto commentDto) {
        var book = bookRepository.findById(commentDto.getBookId())
                .orElseThrow(() ->
                        new NotFoundException(format(ErrorMessage.BOOK_NOT_FOUND,
                                commentDto.getBookId())));
        var bookComment = CommentMapper.mapDtoToComment(commentDto, book);
        return commentRepository.save(bookComment);
    }

    @Transactional
    @Override
    public Comment update(CommentDto commentDto) {
        var comment = commentRepository.findById(commentDto.getId())
                .orElseThrow(() ->
                        new NotFoundException(format(ErrorMessage.COMMENT_NOT_FOUND,
                                commentDto.getId())));

        comment.setText(commentDto.getText());

        return comment;
    }

    @Transactional(readOnly = true)
    @Override
    public Comment getById(long id) {
        return commentRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException(format(ErrorMessage.COMMENT_NOT_FOUND, id)));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Comment> getAllByBookId(long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException(format(ErrorMessage.BOOK_NOT_FOUND, id)));
        return commentRepository.findAllByBook(book);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        commentRepository.deleteById(id);
    }

}
