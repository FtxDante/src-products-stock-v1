DROP SCHEMA IF EXISTS stock;

CREATE SCHEMA stock;

USE stock;

CREATE TABLE categories (
    category_id INT PRIMARY KEY auto_increment,
    category_name VARCHAR(50),
    category_description VARCHAR(300)
);

CREATE TABLE suppliers (
    supplier_id INT PRIMARY KEY auto_increment,
    supplier_name VARCHAR(50),
    supplier_address VARCHAR(300),
    supplier_phone VARCHAR(20),
    supplier_email VARCHAR(50),
    supplier_create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    supplier_update_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE products (
    product_id INT PRIMARY KEY auto_increment,
    product_name VARCHAR(50),
    product_description VARCHAR(300),
    product_price DECIMAL(10, 2),
    product_quantity_in_stock SMALLINT UNSIGNED,
    product_category_id INT,
    product_supplier_id INT,
    product_create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    product_update_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_products_category FOREIGN KEY (product_category_id) REFERENCES categories (category_id),
    CONSTRAINT fk_products_supplier FOREIGN KEY (product_supplier_id) REFERENCES suppliers (supplier_id)
);