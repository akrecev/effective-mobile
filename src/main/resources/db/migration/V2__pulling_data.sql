INSERT INTO users (name, email, password, role)
VALUES ('admin1', 'admin1@mail.com', 'admin1pwd', 'ADMIN'),
       ('admin2', 'admin2@mail.com', 'admin2pwd', 'ADMIN'),
       ('user1', 'user1@mail.com', 'user1pwd', 'USER'),
       ('user2', 'user2@mail.com', 'user2pwd', 'USER');

INSERT INTO tasks (title, description, status, priority, author_id, assignee_id)
VALUES ('task1', 'task1 description', 'PENDING', 'HIGH', 1, 3),
       ('task2', 'task2 description', 'IN_PROGRESS', 'MEDIUM', 1, 3),
       ('task3', 'task3 description', 'COMPLETE', 'LOW', 1, 3),
       ('task4', 'task4 description', 'COMPLETE', 'LOW', 1, 3),
       ('task5', 'task5 description', 'COMPLETE', 'LOW', 1, 3),
       ('task6', 'task6 description', 'COMPLETE', 'LOW', 1, 3),
       ('task7', 'task7 description', 'COMPLETE', 'LOW', 1, 3),
       ('task8', 'task8 description', 'COMPLETE', 'LOW', 1, 3),
       ('task9', 'task9 description', 'COMPLETE', 'LOW', 1, 3),
       ('task10', 'task10 description', 'COMPLETE', 'LOW', 2, 4);

INSERT INTO comments (content, task_id, author_id)
VALUES ('comment 1', 1, 1),
       ('comment 2', 1, 2),
       ('comment 3', 1, 3),
       ('comment 4', 10, 1);


