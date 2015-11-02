package by.romanov.testproject.util;

import java.util.ResourceBundle;

/**
 * Created by graf on 01.11.2015.
 */
public class ConfigurationManager {
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("config");

    private ConfigurationManager() {

    }

    public static String getProperties(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }

}
