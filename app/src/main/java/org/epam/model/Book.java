package org.epam.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.ISBN;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookid")
    private Long bookId;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "isbn")
    @ISBN
    private String isbn;

    @Column(name = "publication_date")
    @Past
    private LocalDate publicationDate;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Genre> genres;

    @Column(name = "number_of_pages")
    private Integer numPages;

    @Column(name = "tags")
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Tag> tags;

    @ManyToOne
    private User currentKeeper;

}
