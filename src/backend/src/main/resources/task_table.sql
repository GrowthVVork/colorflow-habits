CREATE TABLE IF NOT EXISTS colorflow.task(
    task_id INT AUTO_INCREMENT,
	task_name VARCHAR(100) NOT NULL,
	task_description VARCHAR(500),
	task_color CHAR(7) NOT NULL,
	task_status BOOLEAN DEFAULT true,
	create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	last_modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id int,
    category_id int,
    PRIMARY KEY (task_id),
    FOREIGN KEY (user_id) REFERENCES colorflow.user(user_id)
    ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (category_id) REFERENCES colorflow.category(category_id)
    ON DELETE NO ACTION ON UPDATE NO ACTION
);