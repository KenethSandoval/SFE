DROP DATABASE IF EXISTS SistemaFacturacion2;

CREATE DATABASE SistemaFacturacion2;

USE SistemaFacturacion2;

DROP TABLE IF EXISTS administrador;
CREATE TABLE Administrator(
	idAdmin int not null auto_increment,
    userName varchar(50),
	password varchar(20),
    primary key Pk_idAdmin(idAdmin)
);

DROP TABLE IF EXISTS employee;
CREATE TABLE Employee(
	idEmployee int not null auto_increment,
    name varchar(50),
    primary key Pk_idEmployee(idEmployee)
);

DROP TABLE IF EXISTS purchases;
CREATE TABLE purchases(
	idPurchases int not null auto_increment,
    numberPurchase int not null,
    client_name varchar(50) not null,
    date_purchase DATE not null,
    delivery_data DATE not null,
    delivery_place varchar(100) not null,
    price decimal(10, 2) not null,
    totalU decimal(10, 2) not null,
    total decimal(10, 2) not null,
    primary key Pk_purchases(idPurchases)
);

DROP TABLE IF EXISTS orders;
CREATE TABLE orders(
	idOrders int not null auto_increment,
    numberOrders int not null,
    quantity int not null,
    transport varchar(100),
    primary key Pk_orders(idOrders),
    idPurchases int not null,
    constraint Fk_purchases_orders foreign key(idPurchases) references purchases(idPurchases)
);


DROP TABLE IF EXISTS productions;
CREATE TABLE productions(
	idProductions int not null auto_increment,
    infoGeneral varchar(200) not null,
    admission_date date,
    admission_hour datetime,
    estado boolean not null default false,
    total_orders int not null,
    departure_date date,
    price decimal(10, 2),
    total decimal(10, 2),
    primary key Pk_productions(idProductions)
);

DROP TABLE IF EXISTS Factura;
CREATE TABLE bills(
	idBills int not null auto_increment,
    client_name varchar(50) not null,
    address varchar(100) not null,
    phone varchar(10),
    nit varchar(10) default 'C/F',
    description_product varchar(100) not null,
    price_unit decimal(10, 2) not null,
    primary key Pk_bills(idBills),
    idProductions int not null,
    constraint Fk_bill_production foreign key(idProductions) references productions(idProductions)
);