package by.romanov.testproject.controller;

import by.romanov.testproject.entity.Executor;
import by.romanov.testproject.entity.Task;
import by.romanov.testproject.entity.enums.ExecutorStatuses;
import by.romanov.testproject.entity.enums.ExecutorTypes;
import by.romanov.testproject.entity.enums.TaskStatuses;
import by.romanov.testproject.entity.enums.TaskTypes;
import by.romanov.testproject.fileworker.FileWorker;
import by.romanov.testproject.fileworker.TaskFileFilter;
import by.romanov.testproject.service.ExecutorService;
import by.romanov.testproject.service.TaskService;
import by.romanov.testproject.util.ConfigurationManager;
import by.romanov.testproject.util.MessagesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created by graf on 22.10.2015.
 */
@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private ExecutorService executorService;
    @Autowired
    private TaskService taskService;
    private FileWorker fileWorker = new FileWorker();

    @RequestMapping(value = "/homepage")
    public ModelAndView home() throws IOException, InterruptedException {
        ModelAndView mv = new ModelAndView("homePage");
        mv.addObject("tasks", taskService.findTasks());
        TaskFileFilter myFileFilter = new TaskFileFilter();
        return mv;
    }

    @RequestMapping("create_task_page")
    public ModelAndView createTaskPage() {
        ModelAndView mv = new ModelAndView("createTaskPage", "task", new Task());
        mv.addObject("statuses", TaskStatuses.getStatuses());
        mv.addObject("types", TaskTypes.getTypes());
        mv.addObject("executors", executorService.findExecutorsList());
        mv.addObject("tasks", taskService.findFiveLastTasks());
        return mv;
    }

    @RequestMapping("create_task")
    public ModelAndView createTask(@ModelAttribute Task task) {
        ModelAndView mv = null;
        java.util.Date date = new java.util.Date();
        Object param = new java.sql.Timestamp(date.getTime());
        task.setDate((Timestamp) param);
        Executor executor = executorService.getExecutor(task.getExecutor());
        if (executor.getType().equals(ExecutorTypes.READER)) {
            if (task.getType().equals(TaskTypes.READING)) {
                mv = new ModelAndView("redirect:/homepage.html");
                executor.getTasks().add(task);
                executorService.saveExecutor(executor);
                mv.addObject("tasks", taskService.findTasks());
            } else {
                mv = createTaskPage();
                mv.addObject("message", MessagesManager.getProperties("message.fail.reader"));
                return mv;
            }
        } else if (executor.getType().equals(ExecutorTypes.WRITER)) {
            if (task.getType().equals(TaskTypes.WRITING)) {
                mv = new ModelAndView("redirect:/homepage.html");
                executor.getTasks().add(task);
                executorService.saveExecutor(executor);
                mv.addObject("tasks", taskService.findTasks());
            } else {
                mv = createTaskPage();
                mv.addObject("message", MessagesManager.getProperties("message.fail.writer"));
                return mv;
            }
        }
        return mv;
    }

    @RequestMapping("get_tasks")
    public ModelAndView getTasks() {
        ModelAndView mv = new ModelAndView("tasksPage");
        mv.addObject("tasks", taskService.findTasks());
        return mv;
    }

    @RequestMapping("create_executor")
    public ModelAndView createExecutor(@ModelAttribute Executor executor) {
        ModelAndView mv = null;
        if (executorService.createExecutor(executor)) {
            mv = new ModelAndView("redirect:/get_executors.html");
        } else {
            mv = new ModelAndView("createExecutorPage", "executor", new Executor());
            mv.addObject("types", ExecutorTypes.getTypes());
            mv.addObject("statuses", ExecutorStatuses.getStatuses());
            mv.addObject("executors", executorService.findLastFiveExecutors());
            mv.addObject("message", MessagesManager.getProperties("message.fail.executor"));
        }
        return mv;
    }

    @RequestMapping("create_executor_page")
    public ModelAndView createExecutorPage() {
        ModelAndView mv = new ModelAndView("createExecutorPage", "executor", new Executor());
        mv.addObject("types", ExecutorTypes.getTypes());
        mv.addObject("statuses", ExecutorStatuses.getStatuses());
        mv.addObject("executors", executorService.findLastFiveExecutors());
        return mv;
    }

    @RequestMapping("get_executors")
    public ModelAndView getExecutors() {
        ModelAndView mv = new ModelAndView("executorsPage");
        mv.addObject("executors", executorService.findExecutorsList());
        return mv;
    }

    @RequestMapping("deleteTask")
    public ModelAndView deleteTask(@RequestParam Integer id) {
        taskService.deleteTask(id);
        ModelAndView mv = new ModelAndView("redirect:/homepage.html");
        mv.addObject("tasks", taskService.findTasks());
        return mv;
    }

    @RequestMapping("delete_executor")
    public ModelAndView deleteExecutor(@RequestParam String name) {
        executorService.deleteExecutor(name);
        ModelAndView mv = new ModelAndView("redirect:/get_executors.html");
        mv.addObject("executors", executorService.findExecutorsList());
        return mv;
    }

    @RequestMapping("edit_task_page")
    public ModelAndView editTaskPage(@RequestParam Integer id) {
        ModelAndView mv = new ModelAndView("editTaskPage", "task", new Task());
        mv.addObject("taskForEdit", taskService.getTask(id));
        mv.addObject("types", TaskTypes.getTypes());
        mv.addObject("statuses", TaskStatuses.getStatuses());
        mv.addObject("executors", executorService.findExecutorsList());
        return mv;
    }

    @RequestMapping("edit_task")
    public ModelAndView editTask(@ModelAttribute Task task) {
        Executor executor = executorService.getExecutor(task.getExecutor());
        ModelAndView mv = null;
        if (executor.getType().equals(ExecutorTypes.READER)) {
            if (task.getType().equals(TaskTypes.READING)) {
                taskService.editTask(task);
                mv = new ModelAndView("redirect:/homepage.html");
                mv.addObject("tasks", taskService.findTasks());
            } else {
                editTaskPage(task.getId());
                mv.addObject("message", MessagesManager.getProperties("message.fail.reader"));
            }
        }
        if (executor.getType().equals(ExecutorTypes.WRITER)) {
            if (task.getType().equals(TaskTypes.WRITING)) {
                taskService.editTask(task);
                mv = new ModelAndView("redirect:/homepage.html");
                mv.addObject("tasks", taskService.findTasks());
            } else {
                editTaskPage(task.getId());
                mv.addObject("message", MessagesManager.getProperties("message.fail.writer"));
            }
        }
        return mv;
    }

    @RequestMapping("edit_executor_page")
    public ModelAndView editExecutorPage(@RequestParam String name) {
        Executor executorForEdit = executorService.getExecutor(name);
        ModelAndView mv = null;
        if (executorForEdit.getTasks().isEmpty()) {
            mv = new ModelAndView("editExecutorPage", "executor", new Executor());
            mv.addObject("executorForEdit", executorForEdit);
            mv.addObject("types", ExecutorTypes.getTypes());
            mv.addObject("statuses", ExecutorStatuses.getStatuses());
            mv.addObject("executors", executorService.findLastFiveExecutors());
        } else {
            mv = new ModelAndView("executorInfoPage");
            mv.addObject("executor", executorForEdit);
            mv.addObject("message", MessagesManager.getProperties("message.fail.edit.executor"));
        }
        return mv;
    }

    @RequestMapping("edit_executor")
    public ModelAndView editExecutor(@RequestParam String nameExecutorOld, @ModelAttribute Executor executor) {
        ModelAndView mv = null;
        if (executorService.editExecutor(nameExecutorOld, executor)) {
            mv = new ModelAndView("executorInfoPage");
            mv.addObject("executor", executor);
        } else {
            mv = new ModelAndView("editExecutorPage", "executor", new Executor());
            mv.addObject("executorForEdit", executorService.getExecutor(nameExecutorOld));
            mv.addObject("types", ExecutorTypes.getTypes());
            mv.addObject("statuses", ExecutorStatuses.getStatuses());
            mv.addObject("executors", executorService.findLastFiveExecutors());
            mv.addObject("message", MessagesManager.getProperties("message.fail.executor"));
        }
        return mv;
    }

    @RequestMapping("get_executor_info")
    public ModelAndView getExecutorInfo(@RequestParam String name) {
        ModelAndView mv = new ModelAndView("executorInfoPage");
        mv.addObject("executor", executorService.getExecutor(name));
        return mv;
    }

    @RequestMapping("find_by_type")
    public ModelAndView findByType(@RequestParam TaskTypes type) {
        ModelAndView mv = new ModelAndView("tasksPage");
        mv.addObject("tasks", taskService.findTasksByTypeTask(type));
        return mv;
    }

    @RequestMapping("sort_by_alphabet")
    public ModelAndView sortByExecutor() {
        ModelAndView mv = new ModelAndView("tasksPage");
        mv.addObject("tasks", taskService.findTasksByAlphabet());
        return mv;
    }

    @RequestMapping("sort_by_priority")
    public ModelAndView sortByPriority() {
        ModelAndView mv = new ModelAndView("tasksPage");
        mv.addObject("tasks", taskService.findTasksByPriority());
        return mv;
    }

    @RequestMapping("sort_by_date")
    public ModelAndView sortBydate() {
        ModelAndView mv = new ModelAndView("tasksPage");
        mv.addObject("tasks", taskService.findTasksByDate());
        return mv;
    }

    @RequestMapping("find_not_started")
    public ModelAndView findNotStartedTasks() {
        ModelAndView mv = new ModelAndView("tasksPage");
        mv.addObject("tasks", taskService.findTasksNotStarted());
        return mv;
    }

    @RequestMapping("executors_sort_by_alphabet")
    public ModelAndView executorsSortByAlphabet() {
        ModelAndView mv = new ModelAndView("executorsPage");
        mv.addObject("executors", executorService.findExecutorsByName());
        return mv;
    }

    @RequestMapping("executors_sort_by_type")
    public ModelAndView executorsSortByType(ExecutorTypes type) {
        ModelAndView mv = new ModelAndView("executorsPage");
        mv.addObject("executors", executorService.findExecutorsByType(type));
        return mv;
    }

    @RequestMapping("perform")
    public ModelAndView perform(@RequestParam String taskName, String executor, TaskTypes type, Integer id) {
        ModelAndView mv = new ModelAndView("homePage");
        if (type.equals(TaskTypes.WRITING)) {
            FileWorker.fileCreator(taskName, executor);
            mv.addObject("message", MessagesManager.getProperties("message.task.writing.completed"));
            taskService.editStatusesTask(TaskStatuses.COMPLETED, id);
        } else if (type.equals(TaskTypes.READING)) {
            if (!fileWorker.readAndDeleteFile().equals(ConfigurationManager.getProperties("config.no.files"))) {
                mv.addObject("message", MessagesManager.getProperties("message.task.reading.completed"));
                taskService.editStatusesTask(TaskStatuses.COMPLETED, id);
            } else {
                mv.addObject("message", MessagesManager.getProperties("message.task.blocked"));
                taskService.editStatusesTask(TaskStatuses.LOCK, id);
            }
        }
        mv.addObject("tasks", taskService.findTasks());
        return mv;
    }
}
