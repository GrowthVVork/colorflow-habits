package com.growthvvork.colorflow;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ColorflowApplication {
	@Autowired
	private SchemaInitializer schemaInitializer;

	public static void main(String[] args) {
		SpringApplication.run(ColorflowApplication.class, args);
	}
	// Uncomment below code to execute SQL Creation at project
	// start once database is up & cfadmin user is available.
	/*
	@PostConstruct
	public void init() {
		schemaInitializer.executeSqlScripts(
				"classpath:user_table.sql",
				"classpath:category_table.sql",
				"classpath:task_table.sql",
				"classpath:common.sql"
		);
	}
	 */
}
