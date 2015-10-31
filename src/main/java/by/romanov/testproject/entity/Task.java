package by.romanov.testproject.entity;

import by.romanov.testproject.entity.enums.TaskStatuses;
import by.romanov.testproject.entity.enums.TaskTypes;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by graf on 22.10.2015.
 */
@Entity
@Table(name = "tasks")
@GenericGenerator(strategy = "increment", name = "increment")
public class Task {
    @Id
    @Column(name = "task_id", unique = true)
    @GeneratedValue(generator = "increment")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private Timestamp date;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TaskStatuses status;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TaskTypes type;
    @Column(name = "priority")
    private Integer priority;
    @Column(name = "executor")
    private String executor;

    @LazyCollection(value = LazyCollectionOption.FALSE )
    @ManyToMany
    @JoinTable(name = "executors_task", joinColumns = {@JoinColumn(name = "task_id", referencedColumnName = "task_id")}, inverseJoinColumns = {@JoinColumn(name = "executor_id", referencedColumnName = "executor_id")})
    private List<Executor> executors;

    public Task() {
    }

    public Task(String executor, Timestamp date, String name, Integer priority, TaskStatuses status, TaskTypes type) {
        this.executor = executor;
        this.date = date;
        this.name = name;
        this.priority = priority;
        this.status = status;
        this.type = type;
    }

    public List<Executor> getExecutors() {
        return executors;
    }

    public void setExecutors(List<Executor> executors) {
        this.executors = executors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public TaskTypes getType() {
        return type;
    }

    public void setType(TaskTypes type) {
        this.type = type;
    }

    public TaskStatuses getStatus() {
        return status;
    }

    public void setStatus(TaskStatuses status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Task{" +
                "type=" + type +
                ", status=" + status +
                ", priority='" + priority + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", date=" + date +
                ", executor='" + executor + '\'' +
                '}';
    }
}
