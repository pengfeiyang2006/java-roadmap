select version();
create database device_db character set utf8mb4;
use device_db;
create table device(
	id bigint primary key auto_increment,
    name varchar(50) not null,
    location varchar(50),
    status varchar(20)
);
insert into device(name,location,status) values
('数控机床','一号车间','正常运行'),
('激光切割机','二号车间','待维修');
select * from device