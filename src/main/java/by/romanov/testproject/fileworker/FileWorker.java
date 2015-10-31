package by.romanov.testproject.fileworker;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by graf on 31.10.2015.
 */
public class FileWorker {

    private static List<String> pathes = new LinkedList<String>();
    private String path;


    public void fileCreator(String name, String executor) {
        String path ="../resources/files/" + name + executor + "file.txt";
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
                pathes.add(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    public void fileDelete(){
//        File file = new File();
//    }

    public static List<String> getPathes() {
        return pathes;
    }

    public static void setPathes(List<String> pathes) {
        FileWorker.pathes = pathes;
    }


}
