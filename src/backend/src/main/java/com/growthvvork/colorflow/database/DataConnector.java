package com.growthvvork.colorflow.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Component
public class DataConnector {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DataConnector(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void executeQuery(String query) {
        jdbcTemplate.execute(query);
    }

    public List<Map<String, Object>> fetchQueryResults(String query) {
        return jdbcTemplate.queryForList(query);
    }
    public void executeSqlScripts(String... scriptPaths) {
        for (String scriptPath : scriptPaths) {
            try {
                ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
                Resource[] resources = resolver.getResources(scriptPath);
                // Sort resources based on first 2 characters of its name.
                // All passed files must follow convention of XX_filename.sql where XX denotes number
                Arrays.sort(resources, Comparator.comparing(resource ->  Integer.parseInt(resource.getFilename().substring(0, 2))));

                for (Resource resource : resources) {
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
                        StringBuilder script = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            script.append(line).append("\n");
                        }
                        jdbcTemplate.execute(script.toString());
                    }
                }
            } catch (IOException e) {
                // Handle exception if necessary
                e.printStackTrace();
            }
        }
    }
}
