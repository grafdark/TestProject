package by.romanov.testproject.service.impl;

import by.romanov.testproject.dao.ExecutorDao;
import by.romanov.testproject.entity.Executor;
import by.romanov.testproject.entity.enums.ExecutorTypes;
import by.romanov.testproject.service.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by graf on 23.10.2015.
 */
public class ExecutorServiceImpl implements ExecutorService {

    @Autowired
    private ExecutorDao executorDao;

    @Override
    public List<Executor> findExecutorsList() {
        return executorDao.findExecutorsList();
    }

    @Override
    public List<Executor> findExecutorsByType(ExecutorTypes executorTypes) {
        return executorDao.findExecutorsByType(executorTypes);
    }

    @Override
    public List<Executor> findExecutorsByName() {
        return executorDao.findExecutorsByName();
    }

    @Override
    public List<Executor> findLastFiveExecutors() {
        return executorDao.findLastFiveExecutors();
    }

    @Override
    public boolean createExecutor(Executor executor) {
        return executorDao.createExecutor(executor);
    }

    @Override
    public boolean editExecutor(String name, Executor executor) {
        return executorDao.editExecutor(name, executor);
    }

    @Override
    public boolean deleteExecutor(String name) {
        return executorDao.deleteExecutor(name);
    }

    @Override
    public Executor getExecutor(String name) {
        return executorDao.getExecutor(name);
    }

    @Override
    public Executor saveExecutor(Executor executor) {
        return executorDao.saveExecutor(executor);
    }
}
