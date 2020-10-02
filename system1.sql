select customerpurchases.productname,customerpurchases.category,customerpurchases.quantity,customerpurchases.price,customerdata.name from customerpurchases,customerdata where customerpurchases.id=customerdata.id order by customerdata.name; 
select customerpurchases.productname,customerpurchases.category,customerpurchases.quantity,customerpurchases.price,customerdata.name from customerpurchases,customerdata where customerpurchases.id=customerdata.id and customerdata.email='veera@gmail.com'; 

select productsinstore.productid from productsinstore,supplierproducts where productsinstore.productid =supplierproducts.productid and supplierproducts.id=1;
update customerpurchases set quantity = quantity+1 where productid = 4 and id =22;

select * from customerpurchases;
delete customerpurchases where id=22;
select id from customerpurchases where productid=4;
drop table customerpurchases;
create table customerpurchases(
id NUMBER(10) ,
productId number(10),
productName VARCHAR(50),
category VARCHAR(50),
brand VARCHAR(50),
quantity number(10),
price number(10)
);

select * from customerdata;

select * from supplierproducts where id=1 and quantity>40;
select * from supplierproducts;
select * from productsinstore;

create table productsinstore(
productId number(10) primary key,
productName VARCHAR(50),
category VARCHAR(50),
brand VARCHAR(50),
quantity number(10),
price number(10));

drop table productsinstore;

--update supplierproducts set quantity = 111 where id = 1

insert into productsinstore values(rs.get);
-------------------
create table supplierProducts(
id NUMBER(10) PRIMARY KEY,
name VARCHAR(50),
productId number(10) unique,
productName VARCHAR(50),
category VARCHAR(50),
brand VARCHAR(50),
quantity number(10),
price number(10)
);

select * from supplierProducts;
drop table supplierProducts;
CREATE SEQUENCE supplier_sequence;
drop sequence supplier_sequence;
CREATE OR REPLACE TRIGGER supplierProdDataInsert
  BEFORE INSERT ON supplierProducts
  FOR EACH ROW
BEGIN
  SELECT supplier_sequence.nextval
  INTO :new.id
  FROM dual;
END;
insert into supplierProducts(name,productId,productName,category,brand,quantity,price) values('Anjali guptha',1,'samsung j6','mobile','samsung',300,15000);
insert into supplierProducts(name,productId,productName,category,brand,quantity,price) values('prasad',2,'LG 5 star','refrigerator','LG',280,50000);
insert into supplierProducts(name,productId,productName,category,brand,quantity,price) values('varma',3,'Sony full Hd','TV','sony',200,90000);
insert into supplierProducts(name,productId,productName,category,brand,quantity,price) values('Baradwaj',4,'Haier 3star','AC','Haier',300,40000);
insert into supplierProducts(name,productId,productName,category,brand,quantity,price) values('Reddy',5,'Lenovo desktop i3','Laptop','Lenovo',280,32000);
insert into supplierProducts(name,productId,productName,category,brand,quantity,price) values('Ching chong',6,'Real me 3 pro','Mobile','Real me',400,19000);
insert into supplierProducts(name,productId,productName,category,brand,quantity,price) values('Mahendra',7,'Washing Machine 12.0','Washing Machine','ButterFly',400,19000);
insert into supplierProducts(name,productId,productName,category,brand,quantity,price) values('Narendra',8,'water cooler','Cooler','Usha',300,7000);
insert into supplierProducts(name,productId,productName,category,brand,quantity,price) values('Goutham Reddy',9,'Bajaj Platini PX97','Cooler','Bajaj',550,6000);



--------------------------

CREATE TABLE customerData(
id NUMBER(10) PRIMARY KEY,
name VARCHAR(50),
password VARCHAR(50),
email VARCHAR(50));
  
select * from customerData;
CREATE SEQUENCE customerId_sequence;

CREATE OR REPLACE TRIGGER customerDataInsert
  BEFORE INSERT ON customerData
  FOR EACH ROW
BEGIN
  SELECT customerId_sequence.nextval
  INTO :new.id
  FROM dual;
END;

insert into customerData values('anitha','Anu123@','anu@gmail.com');

