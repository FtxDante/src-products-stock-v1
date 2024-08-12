USE stock;

CREATE TABLE stock_movements (
  movement_id INT PRIMARY KEY auto_increment,
  movement_product_id INT,
  movement_type ENUM('IN', 'OUT'),
  movement_quantity SMALLINT UNSIGNED,
  movement_date DATE,
  movement_create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_stock_movements_products FOREIGN KEY (movement_product_id) REFERENCES products (product_id)
);

CREATE TABLE users (
  user_id INT PRIMARY KEY auto_increment,
  user_name VARCHAR(50),
  user_email VARCHAR(50),
  user_password VARCHAR(50),
  user_role ENUM('ADMIN', 'USER', 'MANAGER', 'STOCK_MANAGER'),
  user_create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  user_update_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE purchase_orders (
  purchase_order_id INT PRIMARY KEY auto_increment,
  purchase_order_supplier_id INT,
  purchase_order_total DECIMAL(10, 2),
  purchase_order_create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  purchase_order_update_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT fk_purchase_orders_supplier FOREIGN KEY (purchase_order_supplier_id) REFERENCES suppliers (supplier_id)
);

CREATE TABLE order_items (
  order_item_id INT PRIMARY KEY auto_increment,
  purchase_order_id INT,
  order_item_product_id INT,
  order_item_quantity SMALLINT UNSIGNED,
  order_item_price DECIMAL(10, 2),
  order_item_create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  order_item_update_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT fk_order_items_order FOREIGN KEY (purchase_order_id) REFERENCES purchase_orders (purchase_order_id),
  CONSTRAINT fk_order_items_product FOREIGN KEY (order_item_product_id) REFERENCES products (product_id)
);