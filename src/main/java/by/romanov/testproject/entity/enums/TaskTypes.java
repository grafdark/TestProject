package by.romanov.testproject.entity.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by graf on 24.10.2015.
 */
public enum TaskTypes {
    READING,
    WRITING;

    public static List<String> getTypes() {
        List<String> types = new ArrayList<String>();
        for (TaskTypes type : values()) {
            types.add(type.toString());
        }
        return types;
    }
}
