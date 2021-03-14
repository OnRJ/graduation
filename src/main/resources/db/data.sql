DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM votes;
DELETE FROM meals;
DELETE FROM restaurants;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

INSERT INTO restaurants (name)
VALUES ('Восточная кухня'),
       ('Бухта'),
       ('Советская столовая');

INSERT INTO meals (name, price, restaurant_id)
VALUES ('Каша молочная', 50.0, 100004),
       ('Суп овощной', 100, 100004);

INSERT INTO votes (restaurant_id, user_id)
VALUES (100003, 100000),
       (100004, 100000);
