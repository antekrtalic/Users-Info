package com.user.example.createuser.service;

import com.user.example.createuser.api.service.TaskServiceLayer;
import com.user.example.createuser.dto.TaskDTO;
import com.user.example.createuser.entity.Task;
import com.user.example.createuser.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceLayerImpl implements TaskServiceLayer {

    private TaskRepository taskRepository;
    private ModelMapper modelMapper;

    public TaskServiceLayerImpl(TaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TaskDTO> findAll() {
        return this.taskRepository.findAll().stream()
                .map(task -> modelMapper.map(task, TaskDTO.class)).collect(Collectors.toList());
    }

    @Override
    public TaskDTO findById(Long id) {
        Optional<Task> result = this.taskRepository.findById(id);
        Task task = null;

        if (result.isPresent()) {
            task = result.get();
        } else {
            throw new EntityNotFoundException("Entity with id: " + id + " is not found.");
        }

        return modelMapper.map(task, TaskDTO.class);
    }

    @Override
    public TaskDTO addTask(TaskDTO task) {

        Task taskRequest = modelMapper.map(task, Task.class);

        Task theTask = taskRepository.save(taskRequest);

        TaskDTO taskResponse = modelMapper.map(theTask, TaskDTO.class);

        return taskResponse;
    }

    @Override
    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {

        taskDTO.setId(id);

        Task taskRequest = modelMapper.map(taskDTO, Task.class);

        Task task = taskRepository.save(taskRequest);

        return modelMapper.map(task, TaskDTO.class);
    }

    @Override
    public void deleteTask(Long id) {

        taskRepository.deleteById(id);
    }
}
