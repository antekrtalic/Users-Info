package com.user.example.createuser.api.service;

import com.user.example.createuser.dto.TaskDTO;

import java.util.List;

public interface TaskServiceLayer {

    List<TaskDTO> findAll();
    TaskDTO findById(Long id);
    TaskDTO addTask(TaskDTO task);
    TaskDTO updateTask(Long id, TaskDTO taskDTO);
    void deleteTask(Long id);
}
