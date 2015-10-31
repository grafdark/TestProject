package by.romanov.testproject.dao.impl;

import by.romanov.testproject.dao.TaskDao;
import by.romanov.testproject.entity.Task;
import by.romanov.testproject.entity.enums.TaskTypes;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by graf on 23.10.2015.
 */
public class TaskDaoImpl implements TaskDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Task> takeTaskList() {
        Session session = sessionFactory.openSession();
        List<Task> tasks = session.createQuery("from Task").list();
        session.close();
        return tasks;
    }

    @Override
    public List<Task> takeListByTypeTask(TaskTypes taskTypes) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Task where type=:type");
        query.setParameter("type", taskTypes);
        List<Task> tasks = query.list();
        session.close();
        return tasks;
    }


    @Override
    public List<Task> takeListByAlphabet() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Task order by name");
        List<Task> tasks = query.list();
        session.close();
        return tasks;
    }

    @Override
    public List<Task> takeListByPriority() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Task order by priority desc ");
        List<Task> tasks = query.list();
        session.close();
        return tasks;
    }

    @Override
    public List<Task> takeListByDate() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Task order by date desc ");
        List<Task> tasks = query.list();
        session.close();
        return tasks;
    }

    @Override
    public List<Task> takeFiveLastTask() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Task   order by id desc");
        query.setMaxResults(5);
        List<Task> tasks = query.list();
        session.close();
        return tasks;
    }

    @Override
    public Task editTask(Task task) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(initTaskForUpdate(task));
        tx.commit();
        session.close();
        return task;
    }

    private Task initTaskForUpdate(Task task) {
        Task taskForUpdate = getTask(task.getId());
        taskForUpdate.setStatus(task.getStatus());
        taskForUpdate.setType(task.getType());
        taskForUpdate.setName(task.getName());
        taskForUpdate.setExecutor(task.getExecutor());
        taskForUpdate.setPriority(task.getPriority());
        taskForUpdate.setDate(task.getDate());
        return taskForUpdate;
    }

    @Override
    public Task createTask(Task task) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(task);
        tx.commit();
        session.close();
        return task;
    }

    @Override
    public boolean deleteTask(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Task task = getTask(id);
        if (task != null) {
            session.delete(task);
            tx.commit();
            session.close();
            return true;
        }
        tx.commit();
        session.close();
        return false;
    }

    @Override
    public Task getTask(Integer id) {
        Session session = sessionFactory.openSession();
        Task task = (Task) session.get(Task.class, id);
        session.close();
        return task;
    }
}
