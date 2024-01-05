create table if not exists authors
(
    id   bigserial primary key,
    name varchar(255) not null unique
);

create table if not exists genres
(
    id    bigserial primary key,
    genre varchar(255) not null unique
);

create table if not exists books
(
    id        bigserial primary key,
    genre_id  bigint references genres (id) on delete cascade on update cascade not null,
    author_id bigint references authors (id) on delete cascade on update cascade not null,
    title     varchar(255) not null
);