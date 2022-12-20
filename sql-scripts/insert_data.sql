INSERT INTO movie (movie_id, name) 
VALUES (1, 'Avengers'),
       (2, 'Star Wars'),
       (3, 'Jurassic Park');

INSERT INTO seat (seat_id, hall_no, seat_no) 
VALUES (1, 1, 1), 
       (2, 1, 2), 
       (3, 1, 3), 
       (4, 1, 4), 
       (5, 1, 5),
       (6, 2, 1), 
       (7, 2, 2), 
       (8, 2, 3), 
       (9, 2, 4), 
       (10, 2, 5),
       (11, 3, 1), 
       (12, 3, 2), 
       (13, 3, 3), 
       (14, 3, 4), 
       (15, 3, 5);

INSERT INTO booking (booking_id, movie_id, hall_no, name, datetime, no_of_seats, price)
VALUES (1, 1, 1, 'David', '2022-12-21 09:30:00', 1, 5),
       (2, 2, 1, 'Bob', '2022-12-21 12:00:00', 2, 10),
       (3, 2, 2, 'John', '2022-12-21 12:00:00', 1, 5),
       (4, 3, 3, 'Alice', '2022-12-21 15:00:00', 4, 20);

INSERT INTO booking_seat (booking_id, seat_id)
VALUES (1, 1),
       (2, 2),
       (2, 3),
       (3, 6),
       (4, 11),
       (4, 12),
       (4, 13),
       (4, 14)
