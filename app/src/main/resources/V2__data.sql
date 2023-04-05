INSERT INTO users (Name, Email, Phone, City, Address)
VALUES('John Doe', 'john.doe@example.com', '+1 555-1234', 'New York', '123 Main St'),
                                                          ('Jane Smith', 'jane.smith@example.com', '+1 555-5678', 'Los Angeles', '456 Elm St'),
                                                          ('David Lee', 'david.lee@example.com', '+1 555-9101', 'San Francisco', '789 Oak St'),
                                                          ('Emily Chen', 'emily.chen@example.com', '+1 555-1213', 'Chicago', '246 Maple Ave'),
                                                          ('Michael Kim', 'michael.kim@example.com', '+1 555-1415', 'Boston', '135 Cedar St'),
                                                          ('Sophia Nguyen', 'sophia.nguyen@example.com', '+1 555-1617', 'Seattle', '789 Pine St'),
                                                          ('William Brown', 'william.brown@example.com', '+1 555-1819', 'Austin', '246 Oak Ave');


INSERT INTO books (Title, Author, Publisher, ISBN, Publication_Date, Number_of_Pages, Contributor_Id, Current_Keeper_Id)
VALUES ('The Great Gatsby', 'F. Scott Fitzgerald', 'Scribner', '9780743273565', '1925-04-10', 180, 1, NULL),
       ('To Kill a Mockingbird', 'Harper Lee', 'J. B. Lippincott & Co.', '9780446310789', '1960-07-11', 324, 1, 2),
       ('1984', 'George Orwell', 'Secker & Warburg', '9780451524935', '1949-06-08', 328, 2, 3),
       ('Animal Farm', 'George Orwell', 'Secker & Warburg', '9780451526342', '1945-08-17', 112, 2, 4),
       ('The Hobbit', 'J. R. R. Tolkien', 'Allen & Unwin', '9780261102217', '1937-09-21', 310, 3, NULL),
       ('Harry Potter and the Philosopher''s Stone', 'J. K. Rowling', 'Bloomsbury Publishing', '9781408855652', '1997-06-26', 223, 3, 5),
       ('The Lord of the Rings', 'J. R. R. Tolkien', 'Allen & Unwin', '9780007203543', '1954-07-29', 1178, 4, NULL);

INSERT INTO loan_history (BookID, UserID, Loan_Date, Due_Date)
VALUES (1, 2, '2022-03-20', '2022-04-10'),
       (2, 3, '2022-02-14', '2022-03-07'),
       (3, 4, '2022-01-10', '2022-02-01'),
       (4, 5, '2022-03-02', '2022-03-16'),
       (5, 1, '2022-03-01', '2022-03-15'),
       (6, 2, '2022-02-18', '2022-03-11'),
       (7, 3, '2022-03-15', '2022-04-05');

INSERT INTO reservation_queue (BookID, UserID, Reservation_Date)
VALUES (1, 3, '2022-03-23'),
       (1, 4, '2022-03-24'),
       (2, 5, '2022-02-28'),
       (3, 1, '2022-01-01'),
       (4, 2, '2022-03-07'),
       (5, 3, '2022-03-01'),
       (6, 4, '2022-02-15');

INSERT INTO book_genres (BookID, Genres)
VALUES (1, 'Mystery'),
       (1, 'Thriller'),
       (1, 'Suspense'),
       (2, 'Romance'),
       (2, 'Drama'),
       (3, 'Science Fiction'),
       (3, 'Fantasy');
INSERT INTO book_tags (BookID, Tags)
VALUES (1, 'popular'),
       (1, 'historical'),
       (2, 'funny'),
       (3, 'popular'),
       (3, 'youth interest'),
       (4, 'historical'),
       (5, 'adult preferable');
