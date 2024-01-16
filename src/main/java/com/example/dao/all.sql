CREATE SCHEMA `learning` DEFAULT CHARACTER SET utf8mb4 ;


drop table if exists level_ref_service;
drop table if exists service;
drop table if exists level;
drop table if exists cartitem;
drop table if exists cart;
drop table if exists user;
drop table if exists product;

CREATE TABLE IF NOT EXISTS user (
  userId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  email VARCHAR(1000),
  level INT NOT NULL DEFAULT 1,
  authType ENUM('local', 'github', 'google') DEFAULT 'local',
  authId VARCHAR(100)
);


create table if not exists service(
    serviceId int primary key,
    serviceLocation varchar(50),
    serviceName varchar(50),
    serviceUrl varchar(50)
);

create table if not exists level(
    levelId int primary key,
    levelName varchar(50)
);

create table if not exists level_ref_service(
    levelId int not null,
    serviceId int not null,
    sort int default 1,
    foreign key (levelId) references level(levelId),
    foreign key (serviceId) references service(serviceId),
    constraint unique_sid_and_aid UNIQUE(levelId, serviceId)
);
INSERT INTO user (username, password, email) VALUES ('user1', '123', 'user1@example.com');
insert into user(username,password,email) values('user2','123','user2@example.com');