package by.romanov.testproject.dao.impl;

import by.romanov.testproject.dao.ExecutorDao;
import by.romanov.testproject.entity.Executor;
import by.romanov.testproject.entity.enums.ExecutorTypes;
import com.mysql.jdbc.SQLError;
import org.hibernate.*;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by graf on 23.10.2015.
 */
public class ExecutorDaoImpl implements ExecutorDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Executor> findExecutorsList() {
        Session session = sessionFactory.openSession();
        String sqlQuery = "from Executor";
        List<Executor> listExecutor = session.createQuery(sqlQuery).list();
        session.close();
        return listExecutor;
    }

    @Override
    public List<Executor> findExecutorsByType(ExecutorTypes executorTypes) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Executor where type=:type");
        query.setParameter("type", executorTypes);
        List<Executor> executors = query.list();
        session.close();
        return executors;
    }

    @Override
    public List<Executor> findExecutorsByName() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Executor order by name");
        List<Executor> executors = query.list();
        session.close();
        return executors;
    }

    @Override
    public List<Executor> findLastFiveExecutors() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Executor order by id desc ");
        query.setMaxResults(5);
        List<Executor> executors = query.list();
        session.close();
        return executors;
    }

    @Override
    public boolean createExecutor(Executor executor) {
        Session session = null;
        Transaction tx = null;
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(executor);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean editExecutor(String name, Executor executor) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        tx = session.beginTransaction();
        Executor executorForUpdate = initExecutorForUpdate(name, executor, session);
        session.saveOrUpdate(executorForUpdate);
        tx.commit();
        return true;
    }

    private Executor initExecutorForUpdate(String name, Executor executor, Session session) {
        Query sqlQuery = session.createQuery("from Executor where name=:name");
        sqlQuery.setParameter("name", name);
        Executor executorForUpdate = (Executor) sqlQuery.uniqueResult();
        executorForUpdate.setStatus(executor.getStatus());
        executorForUpdate.setType(executor.getType());
        executorForUpdate.setName(executor.getName());
        return executorForUpdate;
    }

    @Override
    public boolean deleteExecutor(String name) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Executor executor = getExecutor(name);
        if (executor != null) {
            session.delete(executor);
            tx.commit();
            session.close();
            return true;
        }
        session.close();
        return false;
    }

    @Override
    public Executor getExecutor(String name) {
        Session session = sessionFactory.openSession();
        Query sqlQuery = session.createQuery("from Executor where name=:name");
        sqlQuery.setParameter("name", name);
        Executor executor = (Executor) sqlQuery.uniqueResult();
        session.close();
        return executor;
    }

    @Override
    public Executor saveExecutor(Executor executor) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(executor);
        tx.commit();
        session.close();
        return executor;
    }

}
