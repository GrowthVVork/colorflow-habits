package com.growthvvork.colorflow;

import com.growthvvork.colorflow.database.DataConnector;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@SpringBootApplication
public class ColorflowApplication {
//	@Autowired
//	private SchemaInitializer schemaInitializer;
	@Autowired
	private DataConnector dataConnector;

	public static void main(String[] args) {
		SpringApplication.run(ColorflowApplication.class, args); }
		@PostConstruct
		public void init() {
		// Currently going ahead with approach of SQL Scripts execution as part of intialisation.
		Logger logger = LoggerFactory.getLogger(ColorflowApplication.class);
		logger.info("Executing SQL Scripts");
			try {
				dataConnector.executeSqlScripts("/*.sql");
				logger.info("SQL Scripts executed successfully");
			} catch (Exception e) {
				logger.error("Error executing SQL Scripts", e);
			}
		}
	}