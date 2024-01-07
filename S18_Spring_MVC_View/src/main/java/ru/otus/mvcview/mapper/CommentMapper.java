package ru.otus.mvcview.mapper;


import org.springframework.stereotype.Component;
import ru.otus.mvcview.dto.CommentCreateDto;
import ru.otus.mvcview.dto.CommentDto;
import ru.otus.mvcview.model.Book;
import ru.otus.mvcview.model.Comment;


@Component
public class CommentMapper {

    private CommentMapper() {

    }

    public static Comment mapDtoToComment(CommentCreateDto commentCreateDto, Book book) {

        var commentBuilder = Comment.builder();
        commentBuilder.text(commentCreateDto.getText());
        commentBuilder.book(book);

        return commentBuilder.build();
    }

    public static CommentDto mapCommentToDto(Comment comment) {

        var commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setText(comment.getText());
        commentDto.setBookId(comment.getBook().getId());

        return commentDto;
    }
}
