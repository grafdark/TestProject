package by.romanov.testproject.dao;

import by.romanov.testproject.entity.Task;
import by.romanov.testproject.entity.enums.TaskTypes;

import java.util.List;

/**
 * Created by graf on 23.10.2015.
 */
public interface TaskDao {

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
