package ru.otus.datajpa.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.datajpa.exception.NotFoundException;
import ru.otus.datajpa.repository.GenreRepository;
import ru.otus.datajpa.stringifier.GenreStringifier;
import ru.otus.datajpa.service.GenreService;

import java.util.stream.Collectors;

import static java.lang.String.format;

@ShellComponent
@RequiredArgsConstructor
public class GenreCommand {

    private final GenreService genreService;

    private final GenreRepository genreRepository;

    private final GenreStringifier stringifier;

    @ShellMethod(key = {"genres-count"},
            value = "Возвращает количество всех жанров в БД")
    public String handleGetCount() {
        var count = genreService.getCount();
        return format("Общее количество жанров в БД: %d", count);
    }

    @ShellMethod(key = {"new-genre"},
            value = "Добавляет новый жанр в БД: укажите название жанра")
    public String handleAdd(String genreName) {
        return format("Добавлен новый жанр: %s", stringifier.stringify(genreService.create(genreName)));
    }

    @ShellMethod(key = {"change-genre-by-id"},
            value = "Изменяет существующий в БД жанр: укажите идентификатор жанра, название жанра")
    public String handleChange(long id, String genreName) {
        var genre = genreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(format("Не найден жанр с идентификатором %d", id)));
        genre.setName(genreName);
        return format("Жанр изменен: %s", stringifier.stringify(genreService.update(genre)));
    }

    @ShellMethod(key = {"all-genres"},
            value = "Выводит список всех жанров в БД")
    public String handleGetAll() {
        var genres = genreService.getAll(Sort.by(Sort.Direction.ASC,"id"));
        return genres.stream().map(stringifier::stringify).collect(Collectors.joining("\n"));
    }

    @ShellMethod(key = {"genre-by-id"},
            value = "Ищет жанр в БД по его идентификатору: укажите идентификатор жанра")
    public String handleGetById(long id) {
        var genre = genreService.getById(id);
        return format("Жанр найден: %s", stringifier.stringify(genre));
    }

    @ShellMethod(key = {"delete-genre-by-id"},
            value = "Удаляет жанр из БД по его идентификатору: укажите идентификатор жанра")
    public String handleDeleteById(long id) {
        genreService.deleteById(id);
        return format("Жанр с id=%d удален", id);
    }

    @ShellMethod(key = {"delete-all-genres"},
            value = "Удаляет все жанры из БД")
    public String handleDeleteAll() {
        genreService.deleteAll();
        return "Все жанры удалены";
    }
}
