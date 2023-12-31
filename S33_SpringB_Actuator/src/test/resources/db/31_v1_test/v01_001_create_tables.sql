--liquibase formatted sql
--changeset Alexander_V:v01_001


CREATE TABLE IF NOT EXISTS author
(
    id BIGSERIAL,
    name CHARACTER VARYING(255),
    CONSTRAINT author_pk PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS genre
(
    id BIGSERIAL,
    name CHARACTER VARYING(50),
    CONSTRAINT genre_pk PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS book
(
    id BIGSERIAL,
    author_id BIGINT NOT NULL,
    genre_id BIGINT NOT NULL,
    title CHARACTER VARYING(50),
    CONSTRAINT book_pk PRIMARY KEY (id),
    CONSTRAINT book_fk_01 FOREIGN KEY (author_id) REFERENCES author (id) ON DELETE CASCADE,
    CONSTRAINT book_fk_02 FOREIGN KEY (genre_id)  REFERENCES genre  (id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS note
(
    id BIGSERIAL,
    book_id BIGINT NOT NULL,
    note CHARACTER VARYING(255),
    CONSTRAINT note_pk PRIMARY KEY (id),
    CONSTRAINT book_note_fk_01 FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE CASCADE
);
