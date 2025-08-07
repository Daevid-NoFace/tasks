package com.daivcode.tasks.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.daivcode.tasks.domain.entities.Task;
import com.daivcode.tasks.domain.entities.TaskList;
import com.daivcode.tasks.domain.entities.TaskPriority;
import com.daivcode.tasks.domain.entities.TaskStatus;
import com.daivcode.tasks.repositories.TaskListRepository;
import com.daivcode.tasks.repositories.TaskRepository;
import com.daivcode.tasks.services.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskListRepository taskListRepository;

    public TaskServiceImpl(TaskRepository taskRepository, TaskListRepository taskListRepository) {
        this.taskRepository = taskRepository;
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<Task> listTasks(UUID taskListId) {
        // TODO Auto-generated method stub
        return taskRepository.findByTaskListId(taskListId);
    }

    @Override
    public Task createTask(UUID taskListId, Task task) {
        
        if (null != task.getId()) {
            throw new IllegalArgumentException("Task ID must be null for a new task");
        }

        if(null == task.getTitle() || task.getTitle().isBlank()) {
            throw new IllegalArgumentException("Task title cannot be null or blank");
        }

        TaskPriority taskPriority = Optional.ofNullable(task.getPriority()).orElse(TaskPriority.MEDIUM);

        TaskStatus taskStatus = TaskStatus.OPEN;

        TaskList taskList = taskListRepository.findById(taskListId)
                .orElseThrow(() -> new IllegalArgumentException("Task list not found with ID: " + taskListId));

        LocalDateTime now = LocalDateTime.now();

        Task newTask = new Task(
            null,
            task.getTitle(),
            task.getDescription(),
            task.getDueDate(),
            taskPriority,
            taskList,
            taskStatus,
            now,
            now
        );

        return taskRepository.save(newTask);
    }

    @Override
    public Optional<Task> getTask(UUID taskListId, UUID taskId) {
        return taskRepository.findByTaskListIdAndId(taskListId, taskId);
    }

    @Override
    public Task updateTask(UUID taskListId, UUID taskId, Task task) {

        Task existingTask = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task not found with ID: " + taskId));

        if (!existingTask.getTaskList().getId().equals(taskListId)) {
            throw new IllegalArgumentException("Task does not belong to the specified task list");
        }

        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setDueDate(task.getDueDate());
        existingTask.setPriority(Optional.ofNullable(task.getPriority()).orElse(existingTask.getPriority()));
        existingTask.setStatus(Optional.ofNullable(task.getStatus()).orElse(existingTask.getStatus()));
        existingTask.setUpdatedAt(LocalDateTime.now());

        return taskRepository.save(existingTask);
    }
}
