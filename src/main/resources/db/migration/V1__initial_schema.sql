CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       name VARCHAR(255),
                       role VARCHAR(50) NOT NULL
);

CREATE TABLE tasks (
                       id SERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       description TEXT,
                       status VARCHAR(50),
                       priority VARCHAR(50),
                       author_id BIGINT NOT NULL,
                       assignee_id BIGINT,
                       FOREIGN KEY (author_id) REFERENCES users (id),
                       FOREIGN KEY (assignee_id) REFERENCES users (id)
);

CREATE TABLE comments (
                          id SERIAL PRIMARY KEY,
                          content TEXT NOT NULL,
                          task_id BIGINT NOT NULL,
                          author_id BIGINT NOT NULL,
                          FOREIGN KEY (task_id) REFERENCES tasks (id),
                          FOREIGN KEY (author_id) REFERENCES users (id)
);
