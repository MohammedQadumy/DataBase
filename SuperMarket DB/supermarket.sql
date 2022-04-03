create database superMarket ;

use  superMarket ;



create table bank(
banknumber int not null auto_increment  ,
money real ,
primary key(banknumber)
);
alter table bank AUTO_INCREMENT=1; 

create table suppliers (
uniqueNum int  not null auto_increment , 
sName varchar(100),
banknumber int unique  not null   , 
goodstype varchar(50) ,
email varchar(100),
primary key (uniqueNum),
foreign key (banknumber) references bank(bankNumber)
);
alter table suppliers AUTO_INCREMENT=1;

create table goods(
gname varchar(50),
gcode int not null auto_increment,
uniqueNum int not null   ,
primary key (gcode),
foreign key (uniqueNum) references suppliers(uniqueNum)
);

alter table goods AUTO_INCREMENT=1; 

insert into bank(money) values(200);
insert into bank(money) values(0);

select * from bank ;
select money from bank where banknumber = 1 ;
update bank set money = money + 100 where banknumber = 1 ;

select * from suppliers ;
insert into suppliers (sname,bankNumber) values ('qadumy3',1);
insert into suppliers (sname,bankNumber) values ('qadumy',3);

select s.uniqueNum,s.sname,s.banknumber,s.email,s.goodstype  from suppliers s order by s.uniqueNum ;



Insert into goods(gname,uniqueNum) values('nuts',10);
select * from goods ;
select * from goods ;
select gname,count(*) from goods group by gname ;





