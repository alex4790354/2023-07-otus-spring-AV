package ru.otus.nosqldb.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.nosqldb.dto.CommentDto;
import ru.otus.nosqldb.exception.NotFoundException;
import ru.otus.nosqldb.mapper.CommentMapper;
import ru.otus.nosqldb.model.Comment;
import ru.otus.nosqldb.repository.BookRepository;
import ru.otus.nosqldb.repository.CommentRepository;
import ru.otus.nosqldb.service.CommentService;
import ru.otus.nosqldb.utils.ErrorMessage;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final BookRepository bookRepository;

    private final CommentRepository commentRepository;

    @Override
    public Comment create(CommentDto commentDto) {
        var book = bookRepository.findById(commentDto.getBookId())
                .orElseThrow(() ->
                        new NotFoundException(format(ErrorMessage.BOOK_NOT_FOUND,
                                commentDto.getBookId())));
        var bookComment = CommentMapper.mapDtoToComment(commentDto, book);
        return commentRepository.save(bookComment);
    }

    @Override
    public Comment update(CommentDto commentDto) {
        var comment = commentRepository.findById(commentDto.getId())
                .orElseThrow(() ->
                        new NotFoundException(format(ErrorMessage.COMMENT_NOT_FOUND,
                                commentDto.getId())));

        comment.setText(commentDto.getText());

        return comment;
    }

    @Override
    public Comment getById(String id) {
        return commentRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException(format(ErrorMessage.COMMENT_NOT_FOUND, id)));
    }

    @Override
    public List<Comment> getAllByBookId(String bookId) {
        var book = bookRepository.findById(bookId).orElseThrow(() ->
                        new NotFoundException(format(ErrorMessage.BOOK_NOT_FOUND, bookId)));
        return commentRepository.findAllByBookId(book.getId());
    }

    @Override
    public void deleteById(String id) {
        commentRepository.deleteById(id);
    }

}
