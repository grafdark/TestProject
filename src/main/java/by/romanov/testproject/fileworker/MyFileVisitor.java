package by.romanov.testproject.fileworker;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by graf on 31.10.2015.
 */
public class MyFileVisitor extends SimpleFileVisitor {

    public FileVisitResult visitFile(Path path,
                                     BasicFileAttributes fileAttributes) {
        System.out.println("file name:" + path.getFileName());
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult preVisitDirectory(Path path,
                                             BasicFileAttributes fileAttributes) {
        System.out.println("Directory name:" + path);
        return FileVisitResult.CONTINUE;
    }

    public static void getFiles(){
        Path pathSource = Paths.get("D:\\java\\TestProject\\src\\main\\");
        try {
            Files.walkFileTree(pathSource, new MyFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
