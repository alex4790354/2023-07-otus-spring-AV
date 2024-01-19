package ru.otus.securityacl.mapper;


import org.springframework.stereotype.Component;
import ru.otus.securityacl.dto.CommentDto;
import ru.otus.securityacl.model.Comment;


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
