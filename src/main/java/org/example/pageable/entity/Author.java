package org.example.pageable.entity;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.pageable.entity.view.Views;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({Views.Author.class, Views.Book.class})
    private Long id;

    @Column(name = "name")
    @JsonView({Views.Author.class, Views.Book.class})
    private String name;

    @Column(name = "last_name")
    @JsonView({Views.Author.class, Views.Book.class})
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    @JsonView(Views.Author.class)
    private List<Book> bookList;
}
