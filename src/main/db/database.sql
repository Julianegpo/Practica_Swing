create database if not exists Practica_Swing;
use Practica_Swing;


create table Client(
	id int primary key auto_increment,
    nombre varchar(700),
    apellidos varchar(700),
    dni varchar(700),
    poblacion varchar(700),
    codigo_postal int,
    telefono int
);
create table Factory(
	id int primary key auto_increment,
    propietario varchar(700),
    dni varchar(700),
    poblacion varchar(700),
    codigo_postal int,
    telefono int,
    comision float
);
select * from Client;
select * from Factory;
drop database if exists Practica_Swing;