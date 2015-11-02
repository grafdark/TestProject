package by.romanov.testproject.service;

import by.romanov.testproject.entity.Executor;
import by.romanov.testproject.entity.enums.ExecutorTypes;

import java.util.List;

/**
 * Created by graf on 23.10.2015.
 */
public interface ExecutorService {
    List<Executor> findExecutorsList();

    List<Executor> findExecutorsByType(ExecutorTypes executorTypes);

    List<Executor> findExecutorsByName();

    List<Executor> findLastFiveExecutors();

    boolean createExecutor(Executor executor);

    boolean editExecutor(String name, Executor executor);

    boolean deleteExecutor(String name);

    Executor getExecutor(String name);

    Executor saveExecutor(Executor executor);
}
