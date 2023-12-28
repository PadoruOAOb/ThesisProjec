CREATE SCHEMA `learning` DEFAULT CHARACTER SET utf8mb4 ;

create table if not exists user (
	userId int not null auto_increment primary key,
	username varchar(50) not null,
	password varchar(50) not null,
	email varchar(1000),
	level int not null default 1
);

insert into user(username,password,email) values('user1','123','user1@example.com');
insert into user(username,password,email) values('user2','123','user2@example.com');