package com.user.example.createuser.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskDTO {

    private Long id;
    private String title;
    private String description;

    public TaskDTO(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
