CREATE table products (
    id bigserial primari key,
    title varchar(255),
    price bigint
);

INSERT INTO products (title,price) VALUES
      ('Milk', 70 ),
      ('Tomatoes', 120);