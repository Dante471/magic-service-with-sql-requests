CREATE TABLE drivers
(
    name    TEXT PRIMARY KEY,
    age     INT,
    license BIT NOT NULL,
    car_id  INT REFERENCES cars (id)
)

CREATE TABLE cars
(
    id    INT PRIMARY KEY,
    brand TEXT,
    model TEXT,
    price REAL
)
