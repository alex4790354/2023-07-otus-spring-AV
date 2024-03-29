package ru.otus.nosqldb.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.otus.nosqldb.exception.NotFoundException;
import ru.otus.nosqldb.model.Author;
import ru.otus.nosqldb.repository.AuthorRepository;
import ru.otus.nosqldb.service.AuthorService;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public long getCount() {
        return authorRepository.count();
    }

    @Override
    public Author create(String name) {
        var author = new Author();
        author.setName(name);
        return authorRepository.save(author);
    }

    @Override
    public Author update(Author authorDto) {
        var author = authorRepository.findById(authorDto.getId())
                .orElseThrow(() ->
                        new NotFoundException(format("Не найден автор с идентификатором %s", authorDto.getId())));
        author.setName(authorDto.getName());
        return author;
    }

    @Override
    public List<Author> getAll(Sort sort) {
        return authorRepository.findAll(sort);
    }

    @Override
    public Author getById(String id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(format("Не найден автор с идентификатором %s", id)));
    }

    @Override
    public void deleteById(String id) {
        authorRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        authorRepository.deleteAll();
    }

}
