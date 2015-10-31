package by.romanov.testproject.dao;

import by.romanov.testproject.entity.Executor;
import by.romanov.testproject.entity.enums.ExecutorTypes;

import java.util.List;

/**
 * Created by graf on 23.10.2015.
 */
public interface ExecutorDao {
    List<Executor> takeExecutorList();
    List<Executor> takeListByType(ExecutorTypes executorTypes);
    List<Executor> takeListByName();
    List<Executor> takeLastFiveExecutors();
    Executor createExecutor(Executor executor);
    Executor editExecutor(String name, Executor executor);
    boolean deleteExecutor(String name);
    Executor getExecutor(String name);
    Executor saveExecutor(Executor executor);

}
