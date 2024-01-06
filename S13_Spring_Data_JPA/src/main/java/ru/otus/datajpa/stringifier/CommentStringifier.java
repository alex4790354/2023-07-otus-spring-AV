package ru.otus.datajpa.stringifier;

import ru.otus.datajpa.model.Comment;


public interface CommentStringifier {
    String stringify(Comment comment);
}
