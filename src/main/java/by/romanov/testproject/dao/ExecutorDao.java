package by.romanov.testproject.dao;

import by.romanov.testproject.entity.Executor;
import by.romanov.testproject.entity.enums.ExecutorTypes;

import java.util.List;

/**
 * Created by graf on 23.10.2015.
 */
public interface ExecutorDao {
    List<Executor> findExecutorsList();

    List<Executor> findExecutorsByType(ExecutorTypes executorType);

    List<Executor> findExecutorsByName();

    List<Executor> findLastFiveExecutors();

    boolean createExecutor(Executor executor);

    boolean editExecutor(String name, Executor executor);

    boolean deleteExecutor(String name);

    Executor getExecutor(String name);

    Executor saveExecutor(Executor executor);

}
