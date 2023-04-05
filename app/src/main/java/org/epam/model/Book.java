package org.epam.model;

import lombok.Data;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "books")
@Data
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookID")
    private Long bookId;

    @Column(name = "Title")
    private String title;

    @Column(name = "Author")
    private String author;

    @Column(name = "Publisher")
    private String publisher;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "Publication_Date")
    private LocalDate publicationDate;

    @ElementCollection
    @CollectionTable(name = "book_genres", joinColumns = @JoinColumn(name = "BookID"))
    @Column(name = "Genres")
    private Set<String> genres;

    @Column(name = "Number_of_Pages")
    private Integer numPages;

    @ElementCollection
    @CollectionTable(name = "book_tags", joinColumns = @JoinColumn(name = "BookID"))
    @Column(name = "Tags")
    private Set<String> tags;

    @ManyToOne
    @JoinColumn(name = "ContributorId")
    private User contributor;

    @ManyToOne
    @JoinColumn(name = "CurrentKeeperId")
    private User currentKeeper;

}
