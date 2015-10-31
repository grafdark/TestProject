package by.romanov.testproject.entity;

import by.romanov.testproject.entity.enums.ExecutorStatuses;
import by.romanov.testproject.entity.enums.ExecutorTypes;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * Created by graf on 22.10.2015.
 */
@Entity
@Table(name = "executors")
@GenericGenerator(strategy = "increment", name = "increment")
public class Executor {
    @Id
    @Column(name = "executor_id")
    @GeneratedValue(generator = "increment")
    private Integer id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ExecutorStatuses status;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ExecutorTypes type;

    @LazyCollection(value = LazyCollectionOption.FALSE)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "executors_task", joinColumns = {@JoinColumn(name = "executor_id", referencedColumnName = "executor_id")}, inverseJoinColumns = {@JoinColumn(name = "task_id", referencedColumnName = "task_id")})
    private List<Task> tasks;


    public Executor() {
    }

    public Executor(String name, ExecutorStatuses status, ExecutorTypes type) {
        this.name = name;
        this.status = status;
        this.type = type;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public ExecutorStatuses getStatus() {
        return status;
    }

    public void setStatus(ExecutorStatuses status) {
        this.status = status;
    }


    public ExecutorTypes getType() {
        return type;
    }

    public void setType(ExecutorTypes type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Executor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", tasks=" + tasks +
                '}';
    }
}
