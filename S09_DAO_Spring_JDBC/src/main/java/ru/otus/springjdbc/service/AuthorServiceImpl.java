package ru.otus.springjdbc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.springjdbc.exception.NotFoundException;
import ru.otus.springjdbc.model.Author;
import ru.otus.springjdbc.repository.AuthorRepository;

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
    public Author add(String authorName) {
        var author = new Author();
        author.setName(authorName);
        authorRepository.insert(author);
        return author;
    }

    @Override
    public void change(Author authorDto) {
        var author = authorRepository.findById(authorDto.getId())
                .orElseThrow(() ->
                        new NotFoundException(format("Не найден автор с идентификатором %d", authorDto.getId())));
        author.setName(authorDto.getName());
        authorRepository.update(author);
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public long deleteAll() {
        return authorRepository.deleteAll();
    }

}
