package ru.otus.mvcview.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.mvcview.dto.CommentCreateDto;
import ru.otus.mvcview.dto.CommentDto;
import ru.otus.mvcview.exception.NotFoundException;
import ru.otus.mvcview.mapper.CommentMapper;
import ru.otus.mvcview.model.Comment;
import ru.otus.mvcview.repository.BookRepository;
import ru.otus.mvcview.repository.CommentRepository;
import ru.otus.mvcview.service.CommentService;
import ru.otus.mvcview.utils.ErrorMessage;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final BookRepository bookRepository;

    private final CommentRepository commentRepository;

    @Transactional
    @Override
    public CommentDto create(CommentCreateDto commentCreateDto) {
        var book = bookRepository.findById(commentCreateDto.getBookId())
                .orElseThrow(() ->
                        new NotFoundException(format(ErrorMessage.BOOK_NOT_FOUND,
                                commentCreateDto.getBookId())));
        var comment = commentRepository.save(CommentMapper.mapDtoToComment(commentCreateDto, book));
        return CommentMapper.mapCommentToDto(comment);
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
    public List<Comment> getAllByBookId(long bookId) {
        var book = bookRepository.findById(bookId)
                .orElseThrow(() ->
                        new NotFoundException(format(ErrorMessage.BOOK_NOT_FOUND, bookId)));
        return commentRepository.findAllByBook(book);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        commentRepository.deleteById(id);
    }

}
