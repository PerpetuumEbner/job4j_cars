CREATE TABLE cars
(
    id        SERIAL PRIMARY KEY,
    name      TEXT UNIQUE,
    engine_id INT NOT NULL REFERENCES engines (id)
);

CREATE TABLE drivers
(
    id   SERIAL PRIMARY KEY,
    name TEXT UNIQUE
);

CREATE TABLE engines
(
    id   SERIAL PRIMARY KEY,
    name TEXT UNIQUE
);

CREATE TABLE IF NOT EXISTS history_owner
(
    driver_id INT NOT NULL REFERENCES drivers (id),
    car_id    INT NOT NULL REFERENCES cars (id)
)