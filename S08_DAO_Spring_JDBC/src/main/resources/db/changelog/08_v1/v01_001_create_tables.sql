--liquibase formatted sql
--changeset Alexander_V:v01_001


DROP TABLE IF EXISTS author CASCADE;
CREATE TABLE author
(
       id BIGSERIAL,
       name CHARACTER VARYING(255),
       CONSTRAINT author_pk PRIMARY KEY (id)
);

DROP TABLE IF EXISTS genre CASCADE;
CREATE TABLE genre
(
      id BIGSERIAL,
      name CHARACTER VARYING(50),
      CONSTRAINT genre_pk PRIMARY KEY (id)
);

DROP TABLE IF EXISTS book;
CREATE TABLE book
(
     id BIGSERIAL,
     author_id BIGINT NOT NULL,
     genre_id BIGINT NOT NULL,
     name CHARACTER VARYING(50),
     CONSTRAINT book_pk PRIMARY KEY (id)
);

ALTER TABLE book ADD CONSTRAINT book_fk_01 FOREIGN KEY (author_id) REFERENCES author (id);
ALTER TABLE book ADD CONSTRAINT book_fk_02 FOREIGN KEY (genre_id)  REFERENCES genre  (id);
