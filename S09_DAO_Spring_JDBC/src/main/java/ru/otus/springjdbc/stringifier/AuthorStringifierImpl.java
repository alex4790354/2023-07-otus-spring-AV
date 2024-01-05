package ru.otus.springjdbc.stringifier;

import org.springframework.stereotype.Component;
import ru.otus.springjdbc.model.Author;

@Component
public class AuthorStringifierImpl implements AuthorStringifier {
    @Override
    public String stringify(Author author) {
        return "Author(id=" + author.getId() + ", name=" + author.getName() + ")";
    }
}
