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
    private Long firstName;

    @Getter
    @Setter
    @Column(name = "last_name")
    private Long lastName;

    @Getter
    @Setter
    @Column(name = "email")
    private Long email;

    @Getter
    @Setter
    @Column(name = "city")
    private Long city;

    public User() {
    }

    public User(Long firstName, Long lastName, Long email, Long city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
    }
}
