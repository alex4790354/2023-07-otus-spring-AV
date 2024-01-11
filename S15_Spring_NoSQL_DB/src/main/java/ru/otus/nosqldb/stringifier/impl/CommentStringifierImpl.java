package ru.otus.nosqldb.stringifier.impl;

import org.springframework.stereotype.Component;
import ru.otus.nosqldb.model.Comment;
import ru.otus.nosqldb.stringifier.CommentStringifier;


@Component
public class CommentStringifierImpl implements CommentStringifier {

    @Override
    public String stringify(Comment comment) {
        return "Comment(id=" + comment.getId() + ", commentText=" + comment.getText() + ")";
    }
}
