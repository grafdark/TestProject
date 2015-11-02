package by.romanov.testproject.dao;

import by.romanov.testproject.entity.Task;
import by.romanov.testproject.entity.enums.TaskStatuses;
import by.romanov.testproject.entity.enums.TaskTypes;

import java.util.List;

/**
 * Created by graf on 23.10.2015.
 */
public interface TaskDao {

    List<Task> findTasks();

    List<Task> findTasksByTypeTask(TaskTypes taskType);

    List<Task> findTasksByAlphabet();

    List<Task> findTasksByPriority();

    List<Task> findTasksByDate();

    List<Task> findFiveLastTasks();

    List<Task> findTasksNotStarted();

    Task editTask(Task task);

    Task editStatusesTask(TaskStatuses status, Integer id);

    Task createTask(Task task);

    boolean deleteTask(Integer id);

    Task getTask(Integer id);

}
