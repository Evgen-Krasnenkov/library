package org.epam.model;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
import lombok.Data;
import org.hibernate.validator.constraints.ISBN;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "books")
@Data
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookid")
    private Long bookId;

    @Column(name = "Title")
    private String title;

    @Column(name = "Author")
    private String author;

    @Column(name = "Publisher")
    private String publisher;

    @Column(name = "ISBN")
//    @ISBN
    private String isbn;

    @Column(name = "publication_date")
//    @Past
    private LocalDate publicationDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "book_genres", joinColumns = @JoinColumn(name = "bookid"))
    @Column(name = "genres")
    private Set<String> genres;

    @Column(name = "number_of_pages")
    private Integer numPages;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "book_tags", joinColumns = @JoinColumn(name = "bookid"))
    @Column(name = "tags")
    private Set<String> tags;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contributor_id")
    private User contributor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "current_keeper_id")
    private User currentKeeper;

}
