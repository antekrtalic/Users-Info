package com.user.example.createuser.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class UserDTO {

    private Long id;

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Verification of password is required")
    private String verifyPassword;

    @NotBlank(message = "Email is required")
    @Pattern(regexp = "[a-zA-Z0-9_.-]+@[a-zA-Z0-9.-]+$")
    @Getter @Setter private String email;


    public UserDTO() {
    }

    public UserDTO(String username, String password, String verifyPassword, String email) {
        this.username = username;
        this.password = password;
        this.verifyPassword = verifyPassword;
        this.email = email;
    }
}
