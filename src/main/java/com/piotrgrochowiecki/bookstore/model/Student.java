package com.piotrgrochowiecki.bookstore.model;

import lombok.*;

import java.util.List;
@Setter @Getter @NoArgsConstructor
@AllArgsConstructor
public class Student {

    String firstName;
    String lastName;
    String gender;
    String country;
    String notes;
    boolean mailingList;
    @ToString.Exclude
    List<String> programmingSkills;
    @ToString.Exclude
    List<String> hobbies;

}
