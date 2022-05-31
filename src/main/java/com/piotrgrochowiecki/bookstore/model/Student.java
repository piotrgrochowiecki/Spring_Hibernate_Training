package com.piotrgrochowiecki.bookstore.model;

import lombok.*;

import java.util.Collection;
import java.util.List;
@Setter @Getter @NoArgsConstructor
@AllArgsConstructor @ToString
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
    Collection<StudentHobby> hobbies;

}
