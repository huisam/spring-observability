CREATE SCHEMA IF NOT EXISTS product;

CREATE TABLE product.product (
        id int8 NOT NULL,
        amount numeric(38, 2) NULL,
        name varchar(256) NOT NULL,
        CONSTRAINT product_pkey PRIMARY KEY (id)
);