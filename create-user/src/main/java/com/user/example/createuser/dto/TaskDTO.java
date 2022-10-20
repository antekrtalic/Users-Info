package com.user.example.createuser.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskDTO {

    private Long id;

    @NotBlank(message = "title field is required")
    private String title;
    private String description;

    public TaskDTO(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
