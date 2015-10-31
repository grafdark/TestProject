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
    public List<Executor> takeExecutorList() {
        return executorDao.takeExecutorList();
    }

    @Override
    public List<Executor> takeListByType(ExecutorTypes executorTypes) {
        return executorDao.takeListByType(executorTypes);
    }

    @Override
    public List<Executor> takeListByName() {
        return executorDao.takeListByName();
    }

    @Override
    public List<Executor> takeLastFiveExecutors() {
        return executorDao.takeLastFiveExecutors();
    }

    @Override
    public Executor createExecutor(Executor executor) {
        return executorDao.createExecutor(executor);
    }

    @Override
    public Executor editExecutor(String name, Executor executor) {
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
