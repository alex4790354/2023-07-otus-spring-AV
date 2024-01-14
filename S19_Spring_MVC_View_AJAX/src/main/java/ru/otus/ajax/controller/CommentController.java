package ru.otus.ajax.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.ajax.dto.CommentDto;
import ru.otus.ajax.service.CommentService;


import java.util.List;


@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping(value = "/api/books/{id}/comments")
    public List<CommentDto> findAllCommentsForSpecificBook(@PathVariable(value = "id") long id) {
        return commentService.getAllByBookId(id);
    }
}
