CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    name     TEXT UNIQUE,
    password TEXT,
    email    TEXT UNIQUE
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

CREATE TABLE models
(
    id       SERIAL PRIMARY KEY,
    name     TEXT UNIQUE,
    brand_id INT NOT NULL REFERENCES brands (id)
);

CREATE TABLE engines
(
    id   SERIAL PRIMARY KEY,
    name TEXT UNIQUE
);

CREATE TABLE cars
(
    id          SERIAL PRIMARY KEY,
    yearOfIssue INTEGER,
    type_id     INT NOT NULL REFERENCES types (id),
    model_id    INT NOT NULL REFERENCES models (id),
    engine_id   INT NOT NULL REFERENCES engines (id)
);

CREATE TABLE ads
(
    id      SERIAL PRIMARY KEY,
    photo   bytea,
    created TIMESTAMP,
    status  BOOLEAN,
    price   INTEGER,
    mileage INTEGER,
    car_id  INT NOT NULL REFERENCES cars (id),
    user_id INT NOT NULL REFERENCES users (id)
)