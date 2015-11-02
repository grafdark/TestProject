package by.romanov.testproject.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.ResourceBundle;

/**
 * Created by graf on 01.11.2015.
 */
public class MessagesManager {
    private final static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("messages");

    private MessagesManager() {
    }

    public static String getProperties(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }

}
