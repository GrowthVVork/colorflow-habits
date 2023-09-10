CREATE TABLE IF NOT EXISTS colorflow.category(
    category_id INT AUTO_INCREMENT,
	category_name VARCHAR(100) NOT NULL,
	category_description VARCHAR(500),
	category_color CHAR(7),
	create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	last_modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (category_id)
);