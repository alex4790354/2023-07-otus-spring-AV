package ru.otus.webflux.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.webflux.dto.CommentDto;
import ru.otus.webflux.exception.NotFoundException;
import ru.otus.webflux.mapper.CommentMapper;
import ru.otus.webflux.repository.BookRepository;
import ru.otus.webflux.repository.CommentRepository;
import ru.otus.webflux.util.ErrorMessage;

import static java.lang.String.format;


@RestController
@RequiredArgsConstructor
public class CommentController {

    private final BookRepository bookRepository;

    private final CommentRepository commentRepository;

    @GetMapping(value = "/api/books/{id}/comments")
    public Flux<CommentDto> handleGetAllByBookId(@PathVariable(value = "id") String id) {
        return bookRepository.findById(id)
                .switchIfEmpty(Mono.error(() -> new NotFoundException(format(ErrorMessage.BOOK_NOT_FOUND, id))))
                .flatMapMany(book -> commentRepository.findAllByBook(book)
                        .map(CommentMapper::mapCommentToDto));
    }
}
