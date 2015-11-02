package by.romanov.testproject.service.impl;

import by.romanov.testproject.dao.TaskDao;
import by.romanov.testproject.entity.Task;
import by.romanov.testproject.entity.enums.TaskStatuses;
import by.romanov.testproject.entity.enums.TaskTypes;
import by.romanov.testproject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by graf on 23.10.2015.
 */
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public List<Task> findTasks() {
        return taskDao.findTasks();
    }

    @Override
    public List<Task> findTasksByTypeTask(TaskTypes taskTypes) {
        return taskDao.findTasksByTypeTask(taskTypes);
    }

    @Override
    public List<Task> findTasksByAlphabet() {
        return taskDao.findTasksByAlphabet();
    }

    @Override
    public List<Task> findTasksByPriority() {
        return taskDao.findTasksByPriority();
    }

    @Override
    public List<Task> findTasksByDate() {
        return taskDao.findTasksByDate();
    }

    @Override
    public List<Task> findFiveLastTasks() {
        return taskDao.findFiveLastTasks();
    }

    @Override
    public List<Task> findTasksNotStarted() {
        return taskDao.findTasksNotStarted();
    }

    @Override
    public Task editTask(Task task) {
        return taskDao.editTask(task);
    }

    @Override
    public Task editStatusesTask(TaskStatuses status, Integer id) {
        return taskDao.editStatusesTask(status, id);
    }

    @Override
    public Task createTask(Task task) {
        return taskDao.createTask(task);
    }

    @Override
    public boolean deleteTask(Integer id) {
        return taskDao.deleteTask(id);
    }

    @Override
    public Task getTask(Integer id) {
        return taskDao.getTask(id);
    }
}
