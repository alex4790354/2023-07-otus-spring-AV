package ru.otus.datajpa.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.datajpa.exception.NotFoundException;
import ru.otus.datajpa.model.Author;
import ru.otus.datajpa.repository.AuthorRepository;
import ru.otus.datajpa.service.AuthorService;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Transactional(readOnly = true)
    @Override
    public long getCount() {
        return authorRepository.count();
    }

    @Transactional
    @Override
    public Author create(String name) {
        var author = new Author();
        author.setName(name);
        return authorRepository.save(author);
    }

    @Transactional
    @Override
    public Author update(Author authorDto) {
        var author = authorRepository.findById(authorDto.getId())
                .orElseThrow(() ->
                        new NotFoundException(format("Не найден автор с идентификатором %d", authorDto.getId())));
        author.setName(authorDto.getName());
        return author;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> getAll(Sort sort) {
        return authorRepository.findAll(sort);
    }

    @Override
    public Author getById(long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(format("Не найден автор с идентификатором %d", id)));
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        authorRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteAll() {
        authorRepository.deleteAll();
    }

}
