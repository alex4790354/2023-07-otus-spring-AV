package ru.otus.webflux.mapper;


import org.springframework.stereotype.Component;
import ru.otus.webflux.dto.CommentDto;
import ru.otus.webflux.model.Comment;


@Component
public class CommentMapper {

    private CommentMapper() {

    }

    public static CommentDto mapCommentToDto(Comment comment) {

        var commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setText(comment.getText());
        commentDto.setBookId(comment.getBook().getId());

        return commentDto;
    }
}
