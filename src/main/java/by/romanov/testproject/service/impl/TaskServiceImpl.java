package by.romanov.testproject.service.impl;

import by.romanov.testproject.dao.TaskDao;
import by.romanov.testproject.entity.Task;
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
    public List<Task> takeTaskList() {
        return taskDao.takeTaskList();
    }

    @Override
    public List<Task> takeListByTypeTask(TaskTypes taskTypes) {
        return taskDao.takeListByTypeTask(taskTypes);
    }

    @Override
    public List<Task> takeListByAlphabet() {
        return taskDao.takeListByAlphabet();
    }

    @Override
    public List<Task> takeListByPriority() {
        return taskDao.takeListByPriority();
    }

    @Override
    public List<Task> takeListByDate() {
        return taskDao.takeListByDate();
    }

    @Override
    public List<Task> takeFiveLastTask() {
        return taskDao.takeFiveLastTask();
    }

    @Override
    public Task editTask(Task task) {
        return taskDao.editTask(task);
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
