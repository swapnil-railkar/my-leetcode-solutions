package com.leetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class P3408 {
	TreeSet<Task> tasks = null;
    Map<Integer, Integer> taskUserMap = new HashMap<>();
    Map<Integer, Integer> taskPriorityMap = new HashMap<>();
    public P3408(List<List<Integer>> taskList) {
        tasks = new TreeSet<>((a, b) -> {
            if(a.priority == b.priority) {
                return Integer.compare(b.taskId, a.taskId);
            }
            return Integer.compare(b.priority, a.priority);
        });
        for(List<Integer> task : taskList) {
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);
            taskUserMap.put(taskId, userId);
            taskPriorityMap.put(taskId, priority);
            tasks.add(new Task(taskId, userId, priority));
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        taskUserMap.put(taskId, userId);
        taskPriorityMap.put(taskId, priority);
        Task task = new Task(taskId, userId, priority);
        tasks.add(task);
    }
    
    public void edit(int taskId, int newPriority) {
        Task task = new Task(taskId, taskUserMap.get(taskId), taskPriorityMap.get(taskId));
        tasks.remove(task);
        add(task.userId, taskId, newPriority);
    }
    
    public void rmv(int taskId) {
        Task task = new Task(taskId, taskUserMap.get(taskId), taskPriorityMap.get(taskId));
        tasks.remove(task);
        taskUserMap.remove(taskId);
        taskPriorityMap.remove(taskId);
    }
    
    public int execTop() {
        if(tasks.isEmpty() || tasks == null) {
            return -1;
        }
        Task task = tasks.first();
        tasks.remove(task);
        taskUserMap.remove(task.taskId);
        taskPriorityMap.remove(task.taskId);
        return task.userId;
    }

    private static class Task {
        int taskId;
        int userId;
        int priority;

        Task(int taskId, int userId, int priority) {
            this.taskId = taskId;
            this.userId = userId;
            this.priority = priority;
        }
    }
}
