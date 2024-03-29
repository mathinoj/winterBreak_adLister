DROP DATABASE IF EXISTS adListerAttempt_db;

CREATE DATABASE IF NOT EXISTS adListerAttempt_db;

USE adListerAttempt_db;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS gym;

CREATE TABLE IF NOT EXISTS users (
                                     id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                     username VARCHAR(240) NOT NULL UNIQUE,
                                     email VARCHAR(240) NOT NULL,
                                     password VARCHAR(255) NOT NULL,
                                     PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS gym (
                                   id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                   user_id INT UNSIGNED NOT NULL,
                                   name VARCHAR(240) NOT NULL,
                                   type VARCHAR(240) NOT NULL,
                                   membership DOUBLE NOT NULL,
                                   PRIMARY KEY (id)
);