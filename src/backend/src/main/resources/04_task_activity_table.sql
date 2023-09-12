CREATE TABLE IF NOT EXISTS colorflow.task_activity(
    task_activity_id CHAR(36),
	create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	task_id INT,
    PRIMARY KEY (task_activity_id),
    FOREIGN KEY (task_id) REFERENCES colorflow.task(task_id)
    ON DELETE NO ACTION ON UPDATE NO ACTION
);