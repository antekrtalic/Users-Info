package com.user.example.createuser.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserDTO {

    @Getter @Setter private Long id;

    @NotBlank(message = "First name required")
    @Getter @Setter private String firstName;

    @NotBlank(message = "Last name is required")
    @Getter @Setter private String lastName;

    @NotBlank(message = "Email is required")
    @Pattern(regexp = "[a-zA-Z0-9_.-]+@[a-zA-Z0-9.-]+$")
    @Getter @Setter private String email;

    @NotBlank(message = "City is required")
    @Pattern(regexp = "^[a-zA-Z]+$")
    @Getter @Setter private String city;

    public UserDTO() {
    }

    public UserDTO(Long id, String firstName, String lastName, String email, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
    }
}
