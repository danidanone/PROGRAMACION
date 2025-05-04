package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Funciones {

    public static void createFolder(String folderName) {
        // ...
        String path = System.getProperty("user.dir");
        String separador = File.separator;
        String folderPath = path + separador + folderName;
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    public static void createFile(String path, String fileName, String content) {
        try {
            // Create the directory if it doesn't exist
            Path dirPath = Paths.get(path);
            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath);
            }

            // Create the file path
            Path filePath = dirPath.resolve(fileName);

            // Write content to the file (creates or overwrites)
            Files.write(filePath, content.getBytes());

            System.out.println("File created at: " + filePath.toString());
        } catch (IOException e) {
            System.err.println("Failed to create file: " + e.getMessage());
        }
    }

    public static String[] showListFiles(String path) {
        try (Stream<Path> stream = Files.list(Paths.get(path))) {
            return stream
                    .filter(Files::isRegularFile)
                    .map(p -> p.getFileName().toString())
                    .toArray(String[]::new);
        } catch (IOException e) {
            System.err.println("Failed to list files: " + e.getMessage());
            return new String[0];
        }
    }

    public static String showFile(String path, String fileName) {
        Path filePath = Paths.get(path, fileName);
        try {
            return Files.readString(filePath);
        } catch (IOException e) {
            System.err.println("Failed to read file: " + e.getMessage());
            return null;
        }
    }

    public static boolean overWriteFile(String path, String fileName, String newContent) {
        Path filePath = Paths.get(path, fileName);
        try {
            Files.writeString(filePath, newContent, StandardOpenOption.TRUNCATE_EXISTING);
            return true;
        } catch (IOException e) {
            System.err.println("Failed to overwrite file: " + e.getMessage());
            return false;
        }
    }

    public static void deleteFile(String path, String fileName) {
        Path filePath = Paths.get(path, fileName);
        try {
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            System.err.println("Failed to delete file: " + e.getMessage());
        }
    }

    public static int countChars(String path, String fileName) {
        String content = showFile(path, fileName);
        return content != null ? content.length() : 0;
    }

    public static int countWords(String path, String fileName) {
        String content = showFile(path, fileName);
        return content != null ? content.trim().split("\\s+").length : 0;
    }

    public static String swapWords(String path, String fileName, String oldWord, String newWord) {
        String content = showFile(path, fileName);
        if (content != null) {
            String updatedContent = content.replaceAll("\\b" + Pattern.quote(oldWord) + "\\b", newWord);
            overWriteFile(path, fileName, updatedContent);
            return updatedContent;
        }
        return null;
    }

    public static void printPDF(String path, String fileName) {
        // ...
    }
}
