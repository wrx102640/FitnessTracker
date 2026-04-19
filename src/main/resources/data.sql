INSERT INTO users (id, first_name, last_name, birthdate, email) VALUES
                                                                    (1, 'Emma', 'Johnson', DATE '1998-03-10', 'emma.johnson@domain.com'),
                                                                    (2, 'Ethan', 'Taylor', DATE '1975-07-21', 'ethan.taylor@domain.com'),
                                                                    (3, 'Olivia', 'Davis', DATE '1950-11-05', 'olivia.davis@domain.com');

INSERT INTO statistics (id, user_id, total_trainings, total_distance, total_calories_burned) VALUES
                                                                                                 (1, 1, 12, 98.5, 6400),
                                                                                                 (2, 2, 7, 155.2, 7200),
                                                                                                 (3, 3, 4, 21.3, 1300);

INSERT INTO health_metrics (id, user_id, date, weight, height, heart_rate) VALUES
                                                                               (1, 1, DATE '2026-03-20', 61.5, 168.0, 62),
                                                                               (2, 2, DATE '2026-03-20', 82.0, 180.0, 71),
                                                                               (3, 3, DATE '2026-03-20', 69.0, 165.0, 74);

INSERT INTO measurement_note (id, health_metrics_id, note) VALUES
                                                               (1, 1, 'Good condition'),
                                                               (2, 2, 'Stable form'),
                                                               (3, 3, 'Regular check completed');

INSERT INTO trainings (id, user_id, start_time, end_time, activity_type, distance, average_speed) VALUES
                                                                                                      (1, 1, TIMESTAMP '2026-03-18 08:00:00', TIMESTAMP '2026-03-18 09:00:00', 'RUNNING', 10.0, 10.0),
                                                                                                      (2, 2, TIMESTAMP '2026-03-18 17:00:00', TIMESTAMP '2026-03-18 18:30:00', 'CYCLING', 28.5, 19.0),
                                                                                                      (3, 3, TIMESTAMP '2026-03-19 07:30:00', TIMESTAMP '2026-03-19 08:15:00', 'WALKING', 4.2, 5.6);