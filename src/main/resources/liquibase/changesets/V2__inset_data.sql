insert into users (name, username, password)
values ('John Doe', 'johndoe@gmail.com', '$2a$10$E0Yz21hNwz/wIuzv8CCT2ezTsAQo67.TWBJitsPWhgwpzHJvNcWrG'),
       ('Mike Smith', 'mikesmith@gmail.com', '$2a$10$M0RZy1bq5dgbF0oJV6Lh2e5dS.uXUHum9UFZib4y0sFJIMv9E/N0W');

insert into tasks (title, description, status, expiration_date)
values ('Buy cheese', null, 'TODO', '2023-01-29 12:00:00'),
       ('Do homework', 'Math', 'IN_PROGRESS', '2023-01-31 00:00:00'),
       ('Clean rooms', null, 'DONE', null),
       ('Call Mike', 'Ask about meeting', 'TODO', '2023-02-01 00:00:00');

insert into users_tasks (task_id, user_id)
values (1, 2),
       (2, 2),
       (3, 2),
       (4, 1);

insert into users_roles (user_id, role)
values (1, 'ROLE_ADMIN'),
       (1, 'ROLE_USER'),
       (2, 'ROLE_USER');