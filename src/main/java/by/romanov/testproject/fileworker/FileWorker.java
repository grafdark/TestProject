package by.romanov.testproject.fileworker;

import by.romanov.testproject.util.ConfigurationManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by graf on 31.10.2015.
 */

public class FileWorker {

    public static void fileCreator(String name, String executor) {
        BufferedWriter writer = null;
        String fileName = name + executor + ConfigurationManager.getProperties("config.type.file");
        File file = new File(ConfigurationManager.getProperties("config.path") + fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                writer = new BufferedWriter(new FileWriter(file));
                writer.write(ConfigurationManager.getProperties("config.text"));
                writer.newLine();
                writer.write(ConfigurationManager.getProperties("config.name.executor") + executor);
                writer.newLine();
                writer.write(ConfigurationManager.getProperties("config.name.task") + name);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> findAllFiles() {
        File file = new File(ConfigurationManager.getProperties("config.path"));
        File[] paths = file.listFiles(new TaskFileFilter());
        List<String> pathsList = new ArrayList<String>();
        for (File path : paths) {
            pathsList.add(path.toString());
        }
        return pathsList;
    }

    public String getRandomNameFile() {
        if (!findAllFiles().isEmpty()) {
            int random = (int) (Math.random() * findAllFiles().size());
            return findAllFiles().get(random);
        } else {
            return ConfigurationManager.getProperties("config.no.files");
        }
    }

    public String readAndDeleteFile() {
        if (getRandomNameFile().equals(ConfigurationManager.getProperties("config.no.files"))) {
            return ConfigurationManager.getProperties("config.no.files");
        }
        BufferedReader reader = null;
        StringBuffer stringBuffer = new StringBuffer();
        File file = new File(getRandomNameFile());
        try {
            String line;
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                stringBuffer.append(line);
                stringBuffer.append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                file.delete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return stringBuffer.toString();
    }
}
