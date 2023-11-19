CREATE TABLE orders
(
    id          serial primary key,
    user_id     int,
    total_price int,
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp

);

CREATE TABLE order_items
(
    id                serial primary key,
    product_id        int,
    order_id          int,
    quantity          int,
    price_per_product int,
    price             int,
    created_at        timestamp default current_timestamp,
    updated_at        timestamp default current_timestamp
)
