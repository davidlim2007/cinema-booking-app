CREATE TABLE movie
(
    movie_id     SERIAL PRIMARY KEY,
    name         varchar(50) NOT NULL
);

CREATE TABLE seat
(
    seat_id	SERIAL PRIMARY KEY,
    hall_no	integer NOT NULL,
    seat_no	integer NOT NULL
);

CREATE TABLE booking
(
    booking_id  SERIAL PRIMARY KEY,
    movie_id    integer NOT NULL REFERENCES movie (movie_id),
    hall_no	integer NOT NULL,
    name	varchar(50) NOT NULL,
    datetime    timestamp without time zone NOT NULL,
    no_of_seats integer NOT NULL,
    price       double precision NOT NULL
);

CREATE TABLE booking_seat
(
    booking_id integer NOT NULL REFERENCES booking (booking_id),
    seat_id    integer NOT NULL REFERENCES seat (seat_id)
);