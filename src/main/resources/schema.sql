
create table if not exists`users` (
                     id INTEGER AUTO_INCREMENT,
                     fullName VARCHAR(100),
                     address VARCHAR(50),
                     balance LONG,
                     PRIMARY KEY(id)
);
create table if not exists`order`(
                       id int AUTO_INCREMENT NOT NULL  ,
                       orderDate TIMESTAMP ,
                       totalPrice long,
                       isPaid boolean,
                       isDelivered boolean,
                       userId int,
                       PRIMARY KEY(id),
                       FOREIGN KEY(userId) references  `users`(id) ON DELETE RESTRICT
);
create table if not exists items(
                      id int AUTO_INCREMENT NOT NULL ,
                      name varchar(50),
                      price long,
                      category varchar(20),
                      orderId int,
                      PRIMARY KEY(id),
                      FOREIGN KEY(orderId) references  `order`(id) ON DELETE CASCADE
);
