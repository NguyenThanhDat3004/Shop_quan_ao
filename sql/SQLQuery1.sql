CREATE DATABASE clothes_shop_pos;
USE clothes_shop_pos;
GO
CREATE TABLE employee (
    employee_id INT IDENTITY(1,1) PRIMARY KEY,
    username NVARCHAR(50) NOT NULL UNIQUE,
    password NVARCHAR(255) NOT NULL,
    name NVARCHAR(100) NOT NULL,
    role NVARCHAR(30) NOT NULL
);
GO
CREATE TABLE product (
    product_id INT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(100) NOT NULL,
    category NVARCHAR(50) NOT NULL
);
GO
CREATE TABLE product_size (
    size_id INT IDENTITY(1,1) PRIMARY KEY,
    size_name NVARCHAR(10) NOT NULL UNIQUE
);
GO
CREATE TABLE color (
    color_id INT IDENTITY(1,1) PRIMARY KEY,
    color_name NVARCHAR(30) NOT NULL UNIQUE
);
GO
CREATE TABLE product_variant (
    variant_id INT IDENTITY(1,1) PRIMARY KEY,
    product_id INT NOT NULL,
    size_id INT NOT NULL,
    color_id INT NOT NULL,
    price DECIMAL(12,2) NOT NULL,
    stock INT NOT NULL,

    CONSTRAINT uq_product_variant UNIQUE (product_id, size_id, color_id),

    CONSTRAINT fk_variant_product FOREIGN KEY (product_id)
        REFERENCES product(product_id),

    CONSTRAINT fk_variant_size FOREIGN KEY (size_id)
        REFERENCES product_size(size_id),

    CONSTRAINT fk_variant_color FOREIGN KEY (color_id)
        REFERENCES color(color_id)
);
GO
CREATE TABLE orders (
    order_id INT IDENTITY(1,1) PRIMARY KEY,
    employee_id INT NOT NULL,
    order_date DATETIME DEFAULT GETDATE(),
    total_amount DECIMAL(12,2) NOT NULL,
    status NVARCHAR(20) NOT NULL,

    CONSTRAINT fk_order_employee FOREIGN KEY (employee_id)
        REFERENCES employee(employee_id)
);
GO
CREATE TABLE order_item (
    order_item_id INT IDENTITY(1,1) PRIMARY KEY,
    order_id INT NOT NULL,
    variant_id INT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(12,2) NOT NULL,

    CONSTRAINT fk_item_order FOREIGN KEY (order_id)
        REFERENCES orders(order_id),

    CONSTRAINT fk_item_variant FOREIGN KEY (variant_id)
        REFERENCES product_variant(variant_id)
);
GO
CREATE TABLE payment (
    payment_id INT IDENTITY(1,1) PRIMARY KEY,
    order_id INT NOT NULL UNIQUE,
    payment_method NVARCHAR(30) NOT NULL,
    paid_amount DECIMAL(12,2) NOT NULL,
    payment_time DATETIME DEFAULT GETDATE(),
    payment_status NVARCHAR(20) NOT NULL,

    CONSTRAINT fk_payment_order FOREIGN KEY (order_id)
        REFERENCES orders(order_id)
);
GO
CREATE TABLE invoice (
    invoice_id INT IDENTITY(1,1) PRIMARY KEY,
    order_id INT NOT NULL UNIQUE,
    invoice_date DATETIME DEFAULT GETDATE(),

    CONSTRAINT fk_invoice_order FOREIGN KEY (order_id)
        REFERENCES orders(order_id)
);
GO

ALTER TABLE product
ADD image_url NVARCHAR(500);
GO
