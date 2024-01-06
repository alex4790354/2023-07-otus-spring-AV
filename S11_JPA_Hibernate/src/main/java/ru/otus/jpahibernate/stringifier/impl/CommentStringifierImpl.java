package ru.otus.jpahibernate.stringifier.impl;

import org.springframework.stereotype.Component;
import ru.otus.jpahibernate.model.Comment;
import ru.otus.jpahibernate.stringifier.CommentStringifier;


@Component
public class CommentStringifierImpl implements CommentStringifier {

    @Override
    public String stringify(Comment comment) {
        return "Comment(id=" + comment.getId() + ", commentText=" + comment.getText() + ")";
    }
}
