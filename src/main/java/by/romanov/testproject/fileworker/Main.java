package by.romanov.testproject.fileworker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by graf on 31.10.2015.
 */
public class Main {
    public static void main(String[] args){
        {
            Path pathSource = Paths.get("D:\\java\\TestProject\\src\\main\\");
            try {
                Files.walkFileTree(pathSource, new MyFileVisitor());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
