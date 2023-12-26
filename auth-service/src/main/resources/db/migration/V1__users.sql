CREATE table users
(
    id       bigserial primary key,
    username varchar(255) not null unique,
    password varchar(255) not null,
    email    varchar(255) unique
);

INSERT INTO users (username, password, email)
VALUES ('Bob', '$2a$12$fx2MOOF6V.6Q/i8dmotuS.teTOASLjsqzBbPWjkmw9xkNa.5iMK7G', 'bob@mail.ru'), //12345
       ('Max', '{noop}54321', 'max@mail.ru'),
       ('Irina', '$2a$12$fx2MOOF6V.6Q/i8dmotuS.teTOASLjsqzBbPWjkmw9xkNa.5iMK7G', 'irina@mail.ru'), //12345
       ('admin', '$2a$12$dY6cq1x4hu1oMj7LpnkMpu.ASP4kCpOyKYy2g5fni7fakyKTDXUz2', 'admin@mail.ru'); // admin