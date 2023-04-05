DROP TABLE IF EXISTS reservation_queue;
DROP TABLE IF EXISTS loan_history;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS users;
CREATE TABLE books (
                       BookID BIGINT PRIMARY KEY AUTO_INCREMENT,
                       Title VARCHAR(255) NOT NULL,
                       Author VARCHAR(255) NOT NULL,
                       Publisher VARCHAR(255),
                       ISBN VARCHAR(20),
                       Publication_Date DATE,
                       Number_of_Pages INT
);

CREATE TABLE loan_history (
                              LoanID BIGINT PRIMARY KEY AUTO_INCREMENT,
                              BookID BIGINT NOT NULL,
                              UserID BIGINT NOT NULL,
                              Loan_Date DATE NOT NULL,
                              Due_Date DATE NOT NULL,
                              FOREIGN KEY (BookID) REFERENCES books(BookID),
                              FOREIGN KEY (UserID) REFERENCES users(UserID)
);

CREATE TABLE reservation_queue (
                                   ReservationID BIGINT PRIMARY KEY AUTO_INCREMENT,
                                   BookID BIGINT NOT NULL,
                                   UserID BIGINT NOT NULL,
                                   Reservation_Date DATE NOT NULL,
                                   FOREIGN KEY (BookID) REFERENCES books(BookID),
                                   FOREIGN KEY (UserID) REFERENCES users(UserID)
);

CREATE TABLE users (
                       UserID BIGINT PRIMARY KEY AUTO_INCREMENT,
                       Name VARCHAR(255) NOT NULL,
                       Email VARCHAR(255) NOT NULL,
                       Phone VARCHAR(20),
                       City VARCHAR(255),
                       Address VARCHAR(255)
);

CREATE TABLE book_genres (
                             BookID BIGINT NOT NULL,
                             Genres VARCHAR(255) NOT NULL,
                             FOREIGN KEY (BookID) REFERENCES books(BookID),
                             PRIMARY KEY (BookID, Genres)
);

CREATE TABLE book_tags (
                           BookID BIGINT NOT NULL,
                           Tags VARCHAR(255) NOT NULL,
                           FOREIGN KEY (BookID) REFERENCES books(BookID),
                           PRIMARY KEY (BookID, Tags)
);

ALTER TABLE books ADD ContributorId BIGINT;
ALTER TABLE books ADD CurrentKeeperId BIGINT;
ALTER TABLE books ADD CONSTRAINT fk_books_contributor FOREIGN KEY (ContributorId) REFERENCES users(UserID);
ALTER TABLE books ADD CONSTRAINT fk_books_keeper FOREIGN KEY (CurrentKeeperId) REFERENCES users(UserID);
