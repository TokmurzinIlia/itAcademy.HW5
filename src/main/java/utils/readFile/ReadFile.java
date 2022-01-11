package utils.readFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFile {
    public static List<String> readFile(String fileName){
        List<String> expectedWebElementList = null;
        try {
            expectedWebElementList =  Files.lines(Paths.get(fileName),
                    StandardCharsets.UTF_8).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return expectedWebElementList;
    }
}
