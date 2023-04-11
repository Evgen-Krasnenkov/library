create table books (bookid bigint not null auto_increment, author varchar(255), isbn varchar(255), number_of_pages integer, publication_date date, publisher varchar(255), title varchar(255), current_keeper_userid bigint, primary key (bookid)) engine=InnoDB;
create table books_genres (book_bookid bigint not null, genres_id bigint not null, primary key (book_bookid, genres_id)) engine=InnoDB;
create table books_tags (book_bookid bigint not null, tags_id bigint not null, primary key (book_bookid, tags_id)) engine=InnoDB;
create table genre (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table loan_history (loanid bigint not null auto_increment, due_date date, loan_date date, bookid bigint, userid bigint, primary key (loanid)) engine=InnoDB;
create table reservation_queue (reservationid bigint not null auto_increment, reservation_date date, bookid bigint, userid bigint, primary key (reservationid)) engine=InnoDB;
create table tag (id bigint not null auto_increment, tag_name varchar(255), primary key (id)) engine=InnoDB;
create table users (userid bigint not null auto_increment, address varchar(255), city varchar(255) not null, email varchar(255), name varchar(255) not null, phone varchar(255), primary key (userid)) engine=InnoDB;
create table users_contributed_books (user_userid bigint not null, contributed_books_bookid bigint not null) engine=InnoDB;
alter table users_contributed_books add constraint UK_oerg8mmys5y1d6vhlwsosr6ya unique (contributed_books_bookid);
alter table books add constraint FK2albimvwlmt8om3gjdqrojels foreign key (current_keeper_userid) references users (userid);
alter table books_genres add constraint FKhkgu1r5pnqopjs1wugvgxjxui foreign key (genres_id) references genre (id);
alter table books_genres add constraint FKafy90se17uyh9a0l3s6t2yedv foreign key (book_bookid) references books (bookid);
alter table books_tags add constraint FKm3kpr4iy7388y0uomf864ndjo foreign key (tags_id) references tag (id);
alter table books_tags add constraint FK2nxj12racpsybf162w511vggb foreign key (book_bookid) references books (bookid);
alter table loan_history add constraint FK8a26qxvnomorlbhossxkf04o1 foreign key (bookid) references books (bookid);
alter table loan_history add constraint FKbt04gy5f771hdepnrxvjub2be foreign key (userid) references users (userid);
alter table reservation_queue add constraint FK34cm5eg4b7tje6aciaig5khql foreign key (bookid) references books (bookid);
alter table reservation_queue add constraint FKkbd8y07lkhs6wm5cuayt2beim foreign key (userid) references users (userid);
alter table users_contributed_books add constraint FKsxha8b0hnty7gjvqlm3y4rghr foreign key (contributed_books_bookid) references books (bookid);
alter table users_contributed_books add constraint FKq4hqncu3guqsq4udlr0cpwqp2 foreign key (user_userid) references users (userid);