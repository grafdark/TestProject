package by.romanov.testproject.controller;

import by.romanov.testproject.entity.Executor;
import by.romanov.testproject.entity.Task;
import by.romanov.testproject.entity.enums.ExecutorStatuses;
import by.romanov.testproject.entity.enums.ExecutorTypes;
import by.romanov.testproject.entity.enums.TaskStatuses;
import by.romanov.testproject.entity.enums.TaskTypes;
import by.romanov.testproject.fileworker.FileWorker;
import by.romanov.testproject.fileworker.MyFileVisitor;
import by.romanov.testproject.service.ExecutorService;
import by.romanov.testproject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @RequestMapping(value = "/homepage")
    public ModelAndView home() throws IOException, InterruptedException {
        ModelAndView mv = new ModelAndView("homepage");
        mv.addObject("tasks", taskService.takeTaskList());
            Path pathSource = Paths.get("D:\\java\\TestProject\\src\\main\\");
            try {
                Files.walkFileTree(pathSource, new MyFileVisitor());
            } catch (IOException e) {
                e.printStackTrace();
            }
        return mv;
    }

    @RequestMapping("create_task_page")
    public ModelAndView createTaskPage() {
        ModelAndView mv = new ModelAndView("create_task_page", "task", new Task());
        mv.addObject("statuses", TaskStatuses.getStatuses());
        mv.addObject("types", TaskTypes.getTypes());
        mv.addObject("executors",executorService.takeExecutorList());
        mv.addObject("tasks", taskService.takeFiveLastTask());
        return mv;
    }

    @RequestMapping("create_task")
    public ModelAndView createTask(@ModelAttribute Task task) {
        ModelAndView mv =  new ModelAndView("redirect:/homepage.html");
        java.util.Date date = new java.util.Date();
        Object param = new java.sql.Timestamp(date.getTime());
        task.setDate((Timestamp) param);
        Executor executor = executorService.getExecutor(task.getExecutor());
        executor.getTasks().add(task);
        executorService.saveExecutor(executor);
        mv.addObject("tasks", taskService.takeTaskList());
        //fileWorker.fileCreator(task.getName(),executor.getName());
        return mv;
    }

    @RequestMapping("get_tasks")
    public ModelAndView getTasks() {
        ModelAndView mv = new ModelAndView("tasks_page");
        mv.addObject("tasks", taskService.takeTaskList());

        return mv;
    }

    @RequestMapping("create_executor")
    public ModelAndView createExecutor(@ModelAttribute Executor executor) {
        ModelAndView mv = new ModelAndView("redirect:/get_executors.html");
        executorService.createExecutor(executor);
        return mv;
    }

    @RequestMapping("create_executor_page")
    public ModelAndView createExecutorPage() {
        ModelAndView mv = new ModelAndView("create_executor_page", "executor", new Executor());
        mv.addObject("types", ExecutorTypes.getTypes());
        mv.addObject("statuses", ExecutorStatuses.getStatuses());
        mv.addObject("executors", executorService.takeLastFiveExecutors());
        return mv;
    }

    @RequestMapping("get_executors")
    public ModelAndView getExecutorss() {
        ModelAndView mv = new ModelAndView("executors_page");
        mv.addObject("executors", executorService.takeExecutorList());
        return mv;
    }

    @RequestMapping("deleteTask")
    public ModelAndView deleteTask(@RequestParam Integer id){
        taskService.deleteTask(id);
        ModelAndView mv = new ModelAndView("redirect:/homepage.html");
        mv.addObject("tasks", taskService.takeTaskList());
        return mv;
    }

    @RequestMapping("delete_executor")
    public ModelAndView deleteExecutor(@RequestParam String name){
        executorService.deleteExecutor(name);
        ModelAndView mv = new ModelAndView("redirect:/get_executors.html");
        mv.addObject("executors", executorService.takeExecutorList());
        return mv;
    }

    @RequestMapping("edit_task_page")
    public ModelAndView editTaskPage(@RequestParam Integer id){
        ModelAndView mv = new ModelAndView("edit_task_page", "task", new Task());
        mv.addObject("taskForEdit", taskService.getTask(id));
        mv.addObject("types", TaskTypes.getTypes());
        mv.addObject("statuses", TaskStatuses.getStatuses());
        mv.addObject("executors",executorService.takeExecutorList());
       return mv;
    }

    @RequestMapping("edit_task")
    public  ModelAndView editTask(@ModelAttribute Task task){
        taskService.editTask(task);
        ModelAndView mv = new ModelAndView("redirect:/homepage.html");
        mv.addObject("tasks", taskService.takeTaskList());
        return mv;
    }

    @RequestMapping("edit_executor_page")
    public  ModelAndView editExecutorPage(@RequestParam String name){
        ModelAndView mv = new ModelAndView("edit_executor_page", "executor", new Executor());
        mv.addObject("executorForEdit", executorService.getExecutor(name));
        mv.addObject("types", ExecutorTypes.getTypes());
        mv.addObject("statuses", ExecutorStatuses.getStatuses());
        return mv;
    }

    @RequestMapping("edit_executor")
    public  ModelAndView editExecutor(@RequestParam String nameExecutorOld, @ModelAttribute Executor executor){
        executorService.editExecutor(nameExecutorOld, executor);
        ModelAndView mv = new ModelAndView("redirect:/get_executor_info.html");
        mv.addObject("executor", executor);
        return  mv;
    }
    @RequestMapping("get_executor_info")
    public ModelAndView getExecutorInfo(@RequestParam String name){
        ModelAndView mv = new ModelAndView("executor_info_page");
        System.out.println(executorService.getExecutor(name));
        mv.addObject("executor", executorService.getExecutor(name));
        return mv;
    }

    @RequestMapping("take_by_type")
    public ModelAndView takeByType(@RequestParam TaskTypes type){
        ModelAndView mv = new ModelAndView("tasks_page");
        mv.addObject("tasks", taskService.takeListByTypeTask(type));
        return mv;
    }

    @RequestMapping("sort_by_alphabet")
    public ModelAndView sortByExecutor(){
        ModelAndView mv = new ModelAndView("tasks_page");
        mv.addObject("tasks", taskService.takeListByAlphabet());
        return mv;
    }

    @RequestMapping("sort_by_priority")
    public ModelAndView sortByPriority(){
        ModelAndView mv = new ModelAndView("tasks_page");
        mv.addObject("tasks", taskService.takeListByPriority());
        return mv;
    }

    @RequestMapping("sort_by_date")
    public ModelAndView sortBydate() {
        ModelAndView mv = new ModelAndView("tasks_page");
        mv.addObject("tasks", taskService.takeListByDate());
        return mv;
    }
    @RequestMapping("executors_sort_by_alphabet")
    public ModelAndView executorsSortByAlphabet(){
        ModelAndView mv = new ModelAndView("executors_page");
        mv.addObject("executors", executorService.takeListByName());
        return mv;
    }

    @RequestMapping("executors_sort_by_type")
    public  ModelAndView executorsSortByType(ExecutorTypes type){
        ModelAndView mv  = new ModelAndView("executors_page");
        mv.addObject("executors", executorService.takeListByType(type));
        return mv;
    }
}
