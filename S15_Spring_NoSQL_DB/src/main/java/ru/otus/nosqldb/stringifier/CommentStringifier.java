package ru.otus.nosqldb.stringifier;

import ru.otus.nosqldb.model.Comment;


public interface CommentStringifier {
    String stringify(Comment comment);
}
