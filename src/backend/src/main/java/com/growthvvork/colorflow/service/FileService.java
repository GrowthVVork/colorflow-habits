package com.growthvvork.colorflow.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class FileService {

    public List<Path> getFiles(String filePattern) {
        try {
            Path resourcesDirectory = Paths.get("src", "main", "resources");
            return Files.walk(resourcesDirectory)
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(filePattern))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public List<Path> getFilesSorted(String filePattern) {
        try {
            Path resourcesDirectory = Paths.get("src", "main", "resources");
            return Files.walk(resourcesDirectory)
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(filePattern))
                    // Sort the files by first 2 characters of it to execute file content in linear order
                    .sorted(Comparator.comparing(path -> path.getFileName().toString().substring(0, 2)))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }
    public List<String> readFiles(List<Path> files) {
        return files.stream()
                .map(this::readFile)
                .collect(Collectors.toList());
    }

    private String readFile(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
