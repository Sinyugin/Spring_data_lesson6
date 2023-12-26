CREATE TABLE users_roles(
    user_id bigint not null,
    role_id int not null,
    primary key (user_id, role_id),
    foreign key (user_id) references users(id),
    foreign key (role_id) references roles(id)
);

INSERT INTO users_roles(user_id, role_id)
VALUES
    (1,1),
    (2,1),
    (3,2),
    (4,3);