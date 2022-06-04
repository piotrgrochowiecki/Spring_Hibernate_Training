package com.piotrgrochowiecki.bookstore.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter @ToString
@Entity(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(5)
    private String title;
    @Min(1) @Max(10)
    private int rating;
    @Size(max = 600)
    private String description;
    @Min(1)
    private Long pages;

    @ManyToOne
    @NotNull
    private Publisher publisher;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ToString.Exclude
    @NotNull
    private List<Author> authors = new ArrayList<>();

    @ManyToOne
    private Category category;
}
