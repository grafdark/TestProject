package by.romanov.testproject.fileworker;

import by.romanov.testproject.util.ConfigurationManager;

import java.io.File;
import java.io.FileFilter;
import java.util.List;

/**
 * Created by graf on 31.10.2015.
 */
public class TaskFileFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return pathname.isFile() && pathname.getName().endsWith(ConfigurationManager.getProperties("config.type.file"));
    }
}
