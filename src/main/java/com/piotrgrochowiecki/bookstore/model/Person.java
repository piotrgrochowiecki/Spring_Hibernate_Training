package com.piotrgrochowiecki.bookstore.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "persons")
@Setter @Getter @ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String password;
    private String email;

    @OneToOne
    @JoinColumn(name = "personDetails_id", unique = true)
    private PersonDetails personDetails;
}
