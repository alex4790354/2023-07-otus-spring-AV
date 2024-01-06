package ru.otus.datajpa.mapper;


import org.springframework.stereotype.Component;
import ru.otus.datajpa.dto.CommentDto;
import ru.otus.datajpa.model.Book;
import ru.otus.datajpa.model.Comment;


@Component
public class CommentMapper {

    private CommentMapper() {

    }

    public static Comment mapDtoToComment(CommentDto commentDto, Book book) {

        var commentBuilder = Comment.builder();
        commentBuilder.text(commentDto.getText());
        commentBuilder.book(book);

        return commentBuilder.build();
    }
}
