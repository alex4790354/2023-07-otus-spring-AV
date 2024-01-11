package ru.otus.nosqldb.mapper;


import org.springframework.stereotype.Component;
import ru.otus.nosqldb.dto.CommentDto;
import ru.otus.nosqldb.model.Book;
import ru.otus.nosqldb.model.Comment;


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
