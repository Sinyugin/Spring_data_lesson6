CREATE table products (
    id bigserial primary key,
    title varchar(255),
    price bigint
);

INSERT INTO products (title,price) VALUES
      ('Milk', 70 ),
      ('Bread', 45),
      ('eggs', 80),
      ('potato', 25),
      ('cheese', 350),
      ('sour cream', 90),
      ('pasta', 40),
      ('rice', 100),
      ('Tomatoes', 120);