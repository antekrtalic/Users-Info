package com.user.example.createuser.controller;

import com.user.example.createuser.api.service.TaskServiceLayer;
import com.user.example.createuser.dto.TaskDTO;
import com.user.example.createuser.entity.Task;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TaskServiceLayer taskServiceLayer;

    @GetMapping("/")
    public ResponseEntity<List<TaskDTO>> findAll() {
        List<TaskDTO> tasks = taskServiceLayer.findAll();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(taskServiceLayer.findById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TaskDTO> addTask(@Valid @RequestBody TaskDTO taskDTO) {
        return new ResponseEntity<>(taskServiceLayer.addTask(taskDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable("id") Long id, @Valid @RequestBody TaskDTO taskDTO) {
        taskServiceLayer.updateTask(id, taskDTO);
        return new ResponseEntity<>(taskServiceLayer.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long id) {
        taskServiceLayer.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
