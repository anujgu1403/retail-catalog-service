CREATE TABLE categories (
    category_id SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE products (
    product_id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    description TEXT NOT NULL,
    unit_price NUMERIC(18,2) NOT NULL,
    image_url TEXT,
    category_id INT NOT NULL,
    created_date TIMESTAMP,
    
    CONSTRAINT fk_products_categories
        FOREIGN KEY (category_id)
        REFERENCES categories (category_id)
        ON DELETE CASCADE
);

INSERT INTO categories (category_id, name) VALUES
    (1, 'Phones'),
    (2, 'Laptops');

SELECT setval('categories_category_id_seq', 2, true);	

INSERT INTO products (
    product_id, name, description, unit_price, image_url, category_id, created_date
) VALUES
    (1, 'iPhone14', 'iPhone17', 100000.00, '/images/iphone14.png', 1, '2025-11-01'),
    (2, 'Samsung S23', 'Samsung S23', 50000.00, '/images/samsungs23.png', 1, '2025-11-01'),
    (3, 'Dell Laptop', 'Dell Laptop', 60000.00, '/images/dell-laptop.png', 2, '2025-11-01'),
    (4, 'MacBook Pro', 'MacBook Pro', 100000.00, '/images/macbook.png', 2, '2025-11-01');

SELECT setval('products_product_id_seq', 4, true);

select * from products