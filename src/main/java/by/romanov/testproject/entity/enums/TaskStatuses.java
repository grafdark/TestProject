package by.romanov.testproject.entity.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by graf on 24.10.2015.
 */
public enum TaskStatuses {
    NOT_STARTED,
    UNDERWAY,
    LOCK,
    COMPLETED;

    public static List<String> getStatuses() {
        List<String> statuses = new ArrayList<String>();
        for (TaskStatuses status : values()) {
            statuses.add(status.toString());
        }
        return statuses;
    }
}
