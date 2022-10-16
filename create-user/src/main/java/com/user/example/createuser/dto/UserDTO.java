package com.user.example.createuser.dto;

import com.user.example.createuser.entity.Task;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {

    private Long id;

    @NotBlank(message = "Username is required")
    private String username;

    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}")
    private String password;

    @NotBlank(message = "Email is required")
    @Pattern(regexp = "[a-zA-Z0-9_.-]+@[a-zA-Z0-9.-]+$")
    @Getter @Setter private String email;

//    @NotNull
//    @Size(min = 1)
    private List<Task> tasks;
    public UserDTO(String username, String password, String email, List<Task> tasks) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.tasks = tasks;
    }
}
