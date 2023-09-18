CREATE TABLE IF NOT EXISTS colorflow.task_activity(
	create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	task_id INT,
    PRIMARY KEY (task_id, create_time),
    FOREIGN KEY (task_id) REFERENCES colorflow.task(task_id)
    ON DELETE NO ACTION ON UPDATE NO ACTION
);