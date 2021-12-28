# THIS IS WHERE YOU CAN HARD INPUT A LIST OF STUFF FROM THE MIGRATION
USE adListerAttempt_db;

TRUNCATE gym;

INSERT INTO gym (name, type, membership)

VALUES ('RGC Machado', 'BJJ', 135),
       ('Pittmans', 'BJJ', 100),
       ('Alamo Olympic Taekwondo', 'Taekwondo', 225),
       ('Universal Judo', 'Judo', 150);


