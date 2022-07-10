CREATE TABLE ads
(
    id          SERIAL PRIMARY KEY,
    name        TEXT,
    description TEXT,
    photo       bytea,
    created     TIMESTAMP,
    status      BOOLEAN,
    car_id      INT NOT NULL REFERENCES cars (id),
    user_id     INT NOT NULL REFERENCES users (id)
);

CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    name     TEXT UNIQUE,
    password TEXT,
    email    TEXT UNIQUE
);

CREATE TABLE cars
(
    id        SERIAL PRIMARY KEY,
    name      TEXT UNIQUE,
    types_id  INT NOT NULL REFERENCES types (id),
    brands_id INT NOT NULL REFERENCES brands (id),
    engine_id INT NOT NULL REFERENCES engines (id)
);

CREATE TABLE types
(
    id   SERIAL PRIMARY KEY,
    name TEXT UNIQUE
);

CREATE TABLE brands
(
    id   SERIAL PRIMARY KEY,
    name TEXT UNIQUE
);

CREATE TABLE engines
(
    id   SERIAL PRIMARY KEY,
    name TEXT UNIQUE
)