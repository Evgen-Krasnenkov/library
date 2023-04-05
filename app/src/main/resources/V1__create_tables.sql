DROP DATABASE library;
CREATE DATABASE IF NOT EXISTS library;
USE library;

CREATE TABLE IF NOT EXISTS users (
                                     userid BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                     name VARCHAR(255) NOT NULL,
                                     email VARCHAR(255) NOT NULL,
                                     phone VARCHAR(20) NOT NULL,
                                     city VARCHAR(100) NOT NULL,
                                     address VARCHAR(255) NOT NULL,
                                     PRIMARY KEY (userid)
);

CREATE TABLE IF NOT EXISTS books (
                                     BookID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                     Title VARCHAR(255) NOT NULL,
                                     Author VARCHAR(255) NOT NULL,
                                     Publisher VARCHAR(255) NOT NULL,
                                     ISBN VARCHAR(50) NOT NULL,
                                     Publication_Date DATE NOT NULL,
                                     Number_of_Pages INT NOT NULL,
                                     ContributorId BIGINT UNSIGNED NOT NULL,
                                     CurrentKeeperId BIGINT UNSIGNED,
                                     PRIMARY KEY (BookID),
                                     FOREIGN KEY (ContributorId) REFERENCES users (UserID),
                                     FOREIGN KEY (CurrentKeeperId) REFERENCES users (UserID)
);

CREATE TABLE IF NOT EXISTS loan_history (
                                            LoanID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                            BookID BIGINT UNSIGNED NOT NULL,
                                            UserID BIGINT UNSIGNED NOT NULL,
                                            Loan_Date DATE NOT NULL,
                                            Due_Date DATE NOT NULL,
                                            PRIMARY KEY (LoanID),
                                            FOREIGN KEY (BookID) REFERENCES books (BookID),
                                            FOREIGN KEY (UserID) REFERENCES users (UserID)
);

CREATE TABLE IF NOT EXISTS reservation_queue (
                                                 ReservationID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                 BookID BIGINT UNSIGNED NOT NULL,
                                                 UserID BIGINT UNSIGNED NOT NULL,
                                                 Reservation_Date DATE NOT NULL,
                                                 PRIMARY KEY (ReservationID),
                                                 FOREIGN KEY (BookID) REFERENCES books (BookID),
                                                 FOREIGN KEY (UserID) REFERENCES users (UserID)
);



CREATE TABLE IF NOT EXISTS book_genres (
                                           BookID BIGINT UNSIGNED NOT NULL,
                                           Genres VARCHAR(50) NOT NULL,
                                           PRIMARY KEY (BookID, Genres),
                                           FOREIGN KEY (BookID) REFERENCES books (BookID)
);

CREATE TABLE IF NOT EXISTS book_tags (
                                         BookID BIGINT UNSIGNED NOT NULL,
                                         Tags VARCHAR(50) NOT NULL,
                                         PRIMARY KEY (BookID, Tags),
                                         FOREIGN KEY (BookID) REFERENCES books (BookID)
);
