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
    totalU int not null,
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

/* PROCEDIMIENTOS ALMACENADOS */
/* EMPLOYEE */
DELIMITER //
	CREATE PROCEDURE sp_AddEmployee(IN mname VARCHAR(50))
    
	BEGIN
		INSERT INTO sistemafacturacion2.employee(name) VALUES(mname);
	END //
DELIMITER ;

DELIMITER //
	CREATE PROCEDURE sp_UpdateEmployee(IN midEmployee INT, IN mname VARCHAR(50))
    
	BEGIN
		UPDATE sistemafacturacion2.employee 
			SET employee.name = mname
            WHERE employee.idEmployee = midEmployee;
	END //
DELIMITER ;

DELIMITER //
	CREATE PROCEDURE sp_DeleteEmployee(IN midEmployee INT)
    
	BEGIN
		DELETE FROM sistemafacturacion2.employee WHERE employee.idEmployee = midEmployee;
	END //
DELIMITER ;

/* CREACION DE CONSULTAS */
CREATE VIEW vw_GetEmployee AS
	SELECT employee.idEmployee, employee.name FROM sistemafacturacion2.employee;

CALL sp_AddEmployee("ADAFDA");
CALL sp_UpdateEmployee(9, "Nadie");
CALL sp_DeleteEmployee(9);
SELECT * FROM vw_getemployee;


/* PROCEDIMIENTOS ALMACENADOS */
/* BILLS */
DELIMITER //
	CREATE PROCEDURE sp_AddPurchases(IN pnumber_purchase INT, IN pclient_name VARCHAR(50), IN pdate_purchase DATE, IN pdelivery_date DATE, IN  pdelivery_place VARCHAR(100), IN pprice DECIMAL(10,2), IN ptotalU DECIMAL(10, 2), IN ptotal DECIMAL(10,2))
    
	BEGIN
		INSERT INTO sistemafacturacion2.purchases(numberPurchase, client_name, date_purchase, delivery_data, delivery_place, price, totalU, total) VALUES(pnumber_purchase, pclient_name, pdate_purchase, pdelivery_date, pdelivery_place, pprice, ptotalU, ptotal);
	END //
DELIMITER ;
DROP PROCEDURE sp_AddPurchases

DELIMITER //
	CREATE PROCEDURE sp_UpdatePurchases(IN pidpurchases INT, IN pclient_name VARCHAR(50), IN pdate_purchase DATE, IN pdelivery_data DATE, IN pdelivery_place VARCHAR(100), IN pprice DECIMAL(10,2), IN ptotalU INT, IN ptotal DECIMAL(10,2))
    
	BEGIN
		UPDATE sistemafacturacion2.purchases 
			SET purchases.client_name = pclient_name, purchases.date_purchase = pdate_purchase, purchases.delivery_data = pdelivery_data, purchases.delivery_place = pdelivery_place, purchases.price = pprice, purchases.totalU = ptotalU, purchases.total = ptotal
            WHERE purchases.idPurchases = pidpurchases;
	END //
DELIMITER ;

DELIMITER //
	CREATE PROCEDURE sp_DeletePurchases(IN pidPurchase INT)
    
	BEGIN
		DELETE FROM sistemafacturacion2.purchases WHERE purchases.idPurchases = pidPurchase;
	END //
DELIMITER ;

/* CREACION DE CONSULTAS */
CREATE VIEW vw_GetPurchases AS
	SELECT purchases.idPurchases, purchases.numberPurchase, purchases.client_name, purchases.date_purchase, purchases.delivery_data, purchases.delivery_place, purchases.price, purchases.totalU, purchases.total 
    FROM sistemafacturacion2.purchases;

CALL sp_AddPurchases(1, 'Keneth', "2021-01-02", "2021-01-15", "Zona 10 Hangares", 10.00, 10, 100.00);

CALL sp_UpdatePurchases(6, 'Keneth', "2021-01-02", "2021-01-15", "Zona 10 Hangares", 10.00, 10, 100.00);
CALL sp_DeletePurchases(6);
SELECT * FROM vw_getpurchases;

