package by.romanov.testproject.entity.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by graf on 24.10.2015.
 */
public enum ExecutorStatuses {
    ACTIVE, NOT_ACTIVE;

    public static List<String> getStatuses() {
        List<String> statuses = new ArrayList<String>();
        for (ExecutorStatuses status : values()) {
            statuses.add(status.toString());
        }
        return statuses;
    }
}
