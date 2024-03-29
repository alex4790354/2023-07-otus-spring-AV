package ru.otus.nosqldb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentDto {
    private String id;

    private String text;

    private String bookId;
}
