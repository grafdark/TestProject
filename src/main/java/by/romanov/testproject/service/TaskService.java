package by.romanov.testproject.service;

import by.romanov.testproject.entity.Task;
import by.romanov.testproject.entity.enums.TaskTypes;

import java.util.List;

/**
 * Created by graf on 23.10.2015.
 */
public interface TaskService {
    List<Task> takeTaskList();
    List<Task> takeListByTypeTask(TaskTypes taskTypes);
    List<Task> takeListByAlphabet();
    List<Task> takeListByPriority();
    List<Task> takeListByDate();
    List<Task> takeFiveLastTask();
    Task editTask(Task task);
    Task createTask(Task task);
    boolean deleteTask(Integer id);
    Task getTask(Integer id);
}
