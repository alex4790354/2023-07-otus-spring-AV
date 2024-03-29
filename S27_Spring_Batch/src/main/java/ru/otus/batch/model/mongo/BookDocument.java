package ru.otus.batch.model.mongo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Document("books")
public class BookDocument {

    @Id
    private String id;

    private String title;

    @DBRef
    private GenreDocument genreDocument;

    @DBRef
    private AuthorDocument authorDocument;
}
