package com.growthvvork.colorflow;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class SchemaInitializer {
    private final JdbcTemplate jdbcTemplate;

    public SchemaInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void executeSqlScripts(String... scriptPaths) {
        for (String scriptPath : scriptPaths) {
            try {
                ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
                Resource[] resources = resolver.getResources(scriptPath);

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
