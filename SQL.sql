CREATE TABLE instances
(
    id INT PRIMARY KEY NOT NULL,
    kind VARCHAR(10),
    artist_name VARCHAR(255),
    title VARCHAR(255),
    year DATE,
    film_or_concert_place VARCHAR(255)
)

