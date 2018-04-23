

CREATE TABLE category (
 id IDENTITY,
 name VARCHAR(50),
 description VARCHAR(255),
 image_url VARCHAR(50),
 is_active BOOLEAN,

 CONSTRAINT pk_category_id PRIMARY KEY(id)

);

CREATE TABLE user_detail(
  id IDENTITY,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  role VARCHAR(50),
  enabled BOOLEAN,
  password VARCHAR(60),
  email VARCHAR(50),
  contact_number VARCHAR(50),
  CONSTRAINT pk_user_id PRIMARY KEY(id),
);


CREATE TABLE product (
id IDENTITY,
code VARCHAR(20),
name VARCHAR(50),
brand VARCHAR(50),
description VARCHAR(255),
unit_price DECIMAL(10,2),
quantity INT,
is_active BOOLEAN,
category_id INT,
supplier_id INT,
purchases INT DEFAULT 0,
views INT DEFAULT 0,
CONSTRAINT pk_product_id PRIMARY KEY (id),
CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),
);



--the address table to store the user billing and shipping addresses

CREATE TABLE address(
id IDENTITY,
user_id int,
address_line_one VARCHAR(100),
address_line_two VARCHAR(100),
city VARCHAR(20),
state VARCHAR(20),
country VARCHAR(20),
postal_code VARCHAR(10),
is_billing BOOLEAN,
is_shipping BOOLEAN,
CONSTRAINT fk_address_user_id FOREIGN KEY(user_id)REFERENCES user_detail(id),
CONSTRAINT pk_address_id PRIMARY KEY(id)
);

--the cart table to store the user cart top-level details

CREATE TABLE cart(
id IDENTITY,
user_id int,
grand_total DECIMAL(10,2),
cart_lines int,
CONSTRAINT fk_cart_user_id FOREIGN KEY(user_id)REFERENCES user_detail(id),
CONSTRAINT pk_cart_id PRIMARY KEY(id))

);


--the cart line table to store the cart details

CREATE TABLE cart_line (
id IDENTITY,
cart_id int,
total DECIMAL(10,2),
product_id int,
product_count int,
buying_price DECIMAL(10,2),
is_available boolean,

CONSTRAINT fk_cartline_cart_id FOREIGN KEY(cart_id)REFERENCES cart(id),
CONSTRAINT fk_cartline_product_id FOREIGN KEY(product_id)REFERENCES product(id),
CONSTRAINT pk_cartline_id PRIMARY KEY(id)

);


--category details

INSERT INTO category (name,description,image_url,is_active) VALUES ('Laptop','This is description for Laptop Category!','CAT_1.png',true);
INSERT INTO category (name,description,image_url,is_active) VALUES ('Television','This is description for Television Category!','CAT_2.png',true);
INSERT INTO category (name,description,image_url,is_active) VALUES ('Mobile','This is description for Mobile Category!','CAT_3.png',true);

--user details

INSERT INTO user_detail
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES('bala', 'rajen', 'USER', 'true', '$2b$10$xHc5i97m9drnUlyAY9/j/uNoxwRfL1J2Xoz7c.vAel79lwdue.t9u', 'bala@gmail.com', '9987776655');

INSERT INTO user_detail
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES('vishnu', 'vishal', 'SUPPLIER', 'true', '$2b$10$bVdR2FTSKGX91.My2zCzteIu2TlYt92lL3uEZvpaHmWuiVTpx5FNm', 'vishnu@gmail.com', '99189923344');

INSERT INTO user_detail
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES('sathish', 'seon', 'SUPPLIER', 'true', '$2b$10$WA55yaxgTbUisXS62GyTp.I6rN/KpvRps8/SFrt0ehgi6hPIjr/ai', 'sathish@gmail.com', '9999778899');

--adding a supplier correspondance address

INSERT INTO address(user_id,address_line_one,address_line_two,city,state,country,postal_code,is_billing,is_shipping)
VALUES(2,'3C redhills road,vinayagapuram','Near White Palace','chennai','india',600019,true,true);

--product details

INSERT INTO product(code, name, brand, description, unit_price, quantity, is_active,purchases, category_id, supplier_id,views)
VALUES('PRDABC12345', 'iPhone 7', 'Apple', 'This is one of the best android smart phone available in the market right now!', '75000','3', 'true',0, 3,2,0);

INSERT INTO product(code, name, brand, description, unit_price, quantity, is_active,purchases, category_id, supplier_id,views)
VALUES('PRDABC12346', 'Samsung J7 pro', 'Samsung', 'This is one of the best android smart phone available in the market right now!', '22000','2', 'true',0, 3,3,0);

INSERT INTO product(code, name, brand, description, unit_price, quantity, is_active,purchases, category_id, supplier_id,views)
VALUES('PRDABC12347', 'GOOGLE PIXEL', 'google', 'This is one of the best android smart phone available in the market right now!', '65000','4', 'true',0, 3,3,0);

INSERT INTO product(code, name, brand, description, unit_price, quantity, is_active,purchases, category_id, supplier_id,views)
VALUES('PRDPQR11111', 'dell inspiron 5000 series', 'dell', 'This is one of the best Laptop available in the market right now!', '56000','2', 'true',0, 1,2,0);

INSERT INTO product(code, name, brand, description, unit_price, quantity, is_active,purchases,category_id, supplier_id,views)
VALUES('PRDMNO22222', 'Sony HD wave', 'sony', 'This is one of the best television  available in the market right now!', '80000','5', 'true',0,2,3,0);

--cart details
--adding a cart for testing

INSERT INTO cart(user_id,grand_total,cart_lines)

VALUES(null,0,0);
