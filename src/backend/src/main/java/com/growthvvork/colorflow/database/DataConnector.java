package com.growthvvork.colorflow.database;

import com.growthvvork.colorflow.ColorflowApplication;
import com.growthvvork.colorflow.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private FileService fileService;

    public void executeSqlScripts(String... scriptPaths) {
        Logger logger = LoggerFactory.getLogger(ColorflowApplication.class);
        for (String scriptPath : scriptPaths) {
            for(String query : fileService.readFiles(fileService.getFilesSorted(scriptPath))) {
//                logger.error(query);
//                The error was fixed by referring : https://stackoverflow.com/questions/69960902/error-3780-referencing-column-and-referenced-column-in-foreign-key-constraint-a
                executeQuery(query);
            }
        }
    }
}