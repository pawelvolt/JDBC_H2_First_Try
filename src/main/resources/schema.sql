CREATE TABLE carStorage (
car_id integer identity(1,1) NOT NULL,
model varchar(100) NOT NULL,
year integer NOT NULL,
mileage integer NOT NULL,
price integer NOT NULL,
CONSTRAINT pk_car_car_id PRIMARY KEY (car_id)
);

CREATE VIEW PRICE_SORT_ASC AS SELECT * FROM carStorage ORDER BY PRICE ASC;
CREATE VIEW BELOW_10_YEARS AS SELECT * FROM carStorage WHERE year >= YEAR(CURDATE()) - 10 ORDER BY YEAR desc;