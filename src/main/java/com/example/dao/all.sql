CREATE SCHEMA `learning` DEFAULT CHARACTER SET utf8mb4 ;

drop table if exists level_ref_service;
drop table if exists service;
drop table if exists level;
drop table if exists cartitem;
drop table if exists cart;
drop table if exists user;
drop table if exists product;


create table if not exists user (
	userId int not null auto_increment primary key,
	username varchar(50) not null,
	password varchar(50) not null,
	email varchar(1000),
	level int not null default 1
	authType enum('local', 'github', 'google') default 'local',
    authId varchar(100)
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

insert into user(username,password,email,sort) values('user1','123','user1@example.com');
insert into user(username,password,email,sort) values('user2','123','user2@example.com');