package com.example.graphql;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String publisher;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    public Book(Long id, String title, String publisher, Author author) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.author = author;
    }
}
