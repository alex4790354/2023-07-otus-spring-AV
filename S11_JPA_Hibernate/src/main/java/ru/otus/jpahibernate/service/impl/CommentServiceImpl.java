package ru.otus.jpahibernate.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.jpahibernate.dto.CommentDto;
import ru.otus.jpahibernate.exception.NotFoundException;
import ru.otus.jpahibernate.mapper.CommentMapper;
import ru.otus.jpahibernate.model.Comment;
import ru.otus.jpahibernate.repository.CommentRepository;
import ru.otus.jpahibernate.repository.BookRepository;
import ru.otus.jpahibernate.service.CommentService;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final BookRepository bookRepository;

    private final CommentRepository commentRepository;

    @Transactional
    @Override
    public Comment add(CommentDto commentDto) {
        var book = bookRepository.findById(commentDto.getBookId())
                .orElseThrow(() ->
                        new NotFoundException(format("Не найдена книга с идентификатором %d",
                                commentDto.getBookId())));
        var bookComment = CommentMapper.mapDtoToComment(commentDto, book);
        return commentRepository.save(bookComment);
    }

    @Transactional
    @Override
    public Comment change(CommentDto commentDto) {
        var comment = commentRepository.findById(commentDto.getId())
                .orElseThrow(() ->
                        new NotFoundException(format("Не найден комментарий с идентификатором %d",
                                commentDto.getId())));

        comment.setText(commentDto.getText());

        return comment;
    }

    @Transactional(readOnly = true)
    @Override
    public Comment getById(long id) {
        return commentRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException(format("Не найден комментарий с идентификатором %d", id)));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Comment> getAllByBookId(long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException(format("Не найдена книга с идентификатором %d", id)));
        return commentRepository.findAllByBook(book);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        commentRepository.deleteById(id);
    }

}
