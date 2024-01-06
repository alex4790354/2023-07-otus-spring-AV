package ru.otus.jpahibernate.stringifier;

import ru.otus.jpahibernate.model.Comment;


public interface CommentStringifier {
    String stringify(Comment comment);
}
