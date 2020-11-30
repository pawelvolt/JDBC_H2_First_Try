CREATE TABLE carStorage (
car_id integer identity(1,1) NOT NULL,
model varchar(100) NOT NULL,
year integer NOT NULL,
milage integer NOT NULL,
price integer NOT NULL,
CONSTRAINTS pk_car_car_id PRIMARY KEY (car_id)
);