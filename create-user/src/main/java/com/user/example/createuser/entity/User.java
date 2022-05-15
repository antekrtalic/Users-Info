package com.user.example.createuser.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @Column(name = "first_name")
    private String firstName;

    @Getter
    @Setter
    @Column(name = "last_name")
    private String lastName;

    @Getter
    @Setter
    @Column(name = "email")
    private String email;

    @Getter
    @Setter
    @Column(name = "city")
    private String city;

    public User() {
    }

    public User(String firstName, String lastName, String email, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
    }
}
