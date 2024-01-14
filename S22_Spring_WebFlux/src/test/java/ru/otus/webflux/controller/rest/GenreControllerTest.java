package ru.otus.webflux.controller.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import ru.otus.webflux.controller.GenreController;
import ru.otus.webflux.dto.GenreDto;
import ru.otus.webflux.model.Genre;
import ru.otus.webflux.repository.GenreRepository;


import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@DisplayName("Тест GenreController должен")
@WebFluxTest(GenreController.class)
class GenreControllerTest {

    private final List<Genre> expectedGenres = List.of(
            new Genre("1", "firstGenre"),
            new Genre("2", "secondGenre")
    );

    private final List<GenreDto> expectedGenresDto = List.of(
            new GenreDto("1", "firstGenre"),
            new GenreDto("2", "secondGenre")
    );

    @Mock
    private GenreRepository genreRepository;

    @InjectMocks
    private GenreController genreController;

    @Autowired
    private WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        webTestClient = WebTestClient.bindToController(genreController).build();
    }

    @DisplayName("возвращать корректный список всех жанров")
    @Test
    void testHandleGetAll() {
        given(genreRepository.findAll(any(Sort.class)))
                .willReturn(Flux.fromIterable(expectedGenres));

        webTestClient.get().uri("/api/genres").exchange()
                .expectStatus().isOk()
                .expectBodyList(GenreDto.class)
                .hasSize(2)
                .isEqualTo(expectedGenresDto);

        verify(genreRepository).findAll(any(Sort.class));
    }
}

