package com.user.example.createuser.service;

import com.user.example.createuser.dto.TaskDTO;
import com.user.example.createuser.entity.Task;
import com.user.example.createuser.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTests {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceLayerImpl taskService;

    private Task task;

    private Task taskTwo;

    private TaskDTO taskDTO;

    @Spy
    private ModelMapper modelMapper;

    @BeforeEach
    public void setup() {
        task = new Task(1L, "Test taskService", "Create test for taskService");
        taskTwo = new Task(2L, "Test taskRepo", "Create test for taskRepository");
        taskDTO = new TaskDTO(1L, "Test taskService", "Create test for taskService");
    }


    @DisplayName("JUnit test for addTask")
    @Test
    public void givenTaskObject_whenAddTask_thenReturnTaskObject() {

        when(taskRepository.save(task)).thenReturn(task);

        TaskDTO savedTask = taskService.addTask(taskDTO);

        assertThat(savedTask).isNotNull();
    }


    @DisplayName("JUnit test for findAll method")
    @Test
    public void givenTasksList_whenFindAll_thenReturnTasksList() {

        when(taskRepository.findAll()).thenReturn(List.of(task, taskTwo));

        List<Task> taskList = taskRepository.findAll();

        assertThat(taskList).isNotNull();

        assertThat(taskList.size()).isEqualTo(2);

    }

    @DisplayName("JUnit test for findById method")
    @Test
    public void givenTaskID_whenFindById_thenReturnTask() {

        when(taskRepository.findById(task.getId())).thenReturn(Optional.of(task));

        TaskDTO actual = taskService.findById(taskDTO.getId());

        assertThat(actual).usingRecursiveComparison().isEqualTo(taskDTO);
        verify(taskRepository, times(1)).findById(taskDTO.getId());
        verifyNoMoreInteractions(taskRepository);
    }

    @DisplayName("JUnit test for updateTask method")
    @Test
    public void givenTaskObject_whenUpdateTask_thenReturnUpdatedTask() {

        given(taskRepository.save(task)).willReturn(task);

        task.setTitle("Fix controller");
        taskDTO.setTitle("Fix controller");

        TaskDTO updateTask = taskService.updateTask(taskDTO.getId(), taskDTO);

        assertThat(updateTask.getTitle()).isEqualTo("Fix controller");

    }

    @DisplayName("JUnit test for deleteTask method")
    @Test
    public void givenTaskID_whenDeleteTask_Then() {

        doNothing().when(taskRepository).deleteById(task.getId());

        taskService.deleteTask(task.getId());
        verify(taskRepository, times(1)).deleteById(task.getId());
        verifyNoMoreInteractions(taskRepository);
    }


}