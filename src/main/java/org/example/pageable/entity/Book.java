package org.example.pageable.entity;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.pageable.entity.view.Views;

import java.time.Year;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({Views.Author.class, Views.Book.class})
    private Long id;

    @Column(name = "title")
    @JsonView({Views.Author.class, Views.Book.class})
    private String title;

    @Column(name = "year_of_writting")
    @JsonView({Views.Author.class, Views.Book.class})
    private Year yearOfWriting;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.REFRESH)
    @JsonView(Views.Book.class)
    private Author author;
}
