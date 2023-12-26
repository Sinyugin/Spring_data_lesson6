CREATE TABLE orders
(
    id          serial primary key,
    username    varchar(255) not null,
    total_price int,
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp

);

CREATE TABLE order_items
(
    id                bigserial primary key,
    product_id        bigint not null references products (id),
    order_id          bigint not null references orders (id),
    quantity          int    not null,
    price_per_product int    not null,
    price             int    not null,
    created_at        timestamp default current_timestamp,
    updated_at        timestamp default current_timestamp
)
