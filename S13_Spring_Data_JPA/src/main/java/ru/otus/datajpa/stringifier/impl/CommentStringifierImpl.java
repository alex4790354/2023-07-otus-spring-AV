package ru.otus.datajpa.stringifier.impl;

import org.springframework.stereotype.Component;
import ru.otus.datajpa.model.Comment;
import ru.otus.datajpa.stringifier.CommentStringifier;


@Component
public class CommentStringifierImpl implements CommentStringifier {

    @Override
    public String stringify(Comment comment) {
        return "Comment(id=" + comment.getId() + ", commentText=" + comment.getText() + ")";
    }
}
