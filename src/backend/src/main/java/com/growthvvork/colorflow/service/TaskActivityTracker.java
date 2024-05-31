package com.growthvvork.colorflow.service;

import com.growthvvork.colorflow.database.DataConnector;
import com.growthvvork.colorflow.model.Task;
import com.growthvvork.colorflow.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

public class TaskActivityTracker {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskActivityTracker(TaskRepository taskRepository, DataConnector dataConnector) {
        this.taskRepository = taskRepository;
        this.dataConnector = dataConnector;
    }

    @Autowired
    public DataConnector dataConnector;
    public void insertActivityTaskStatus(Timestamp timestamp, Task task) {
        try {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("INSERT INTO activity_task_status (timestamp, activity_name, activity_status) ")
                    .append("VALUES ('")
                    .append(timestamp)
                    .append("', '")
                    .append(task.getTaskName())
                    .append("', '").
                    append(task.getTaskStatus()).append("')");

            String query = queryBuilder.toString();
            dataConnector.executeQuery(query);
        } catch (Exception e) {
            // Handle exception if necessary
            e.printStackTrace();
        }
    }
}
