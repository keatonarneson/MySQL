create database if not exists sports;

use sports;

drop table if exists sports;

create table sports (
  id INT(10) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  PRIMARY KEY(ID)
);