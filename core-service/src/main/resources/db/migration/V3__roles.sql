CREATE TABLE roles(
    id serial primary key,
    name varchar(50) not null
);

INSERT INTO roles (name)
VALUES
    ('ROLE_USER'),
    ('ROLE_MANAGER'),
    ('ROLE_ADMIN');