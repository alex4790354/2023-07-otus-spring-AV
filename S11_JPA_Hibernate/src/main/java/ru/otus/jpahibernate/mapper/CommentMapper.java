package ru.otus.jpahibernate.mapper;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.jpahibernate.dto.CommentDto;
import ru.otus.jpahibernate.model.Book;
import ru.otus.jpahibernate.model.Comment;


@Component
@NoArgsConstructor
public class CommentMapper {

    public static Comment mapDtoToComment(CommentDto commentDto, Book book) {

        var commentBuilder = Comment.builder();
        commentBuilder.text(commentDto.getText());
        commentBuilder.book(book);

        return commentBuilder.build();
    }
}
