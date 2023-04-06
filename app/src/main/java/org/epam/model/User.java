package org.epam.model;

import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NonNull;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Long userId;

    @Column(name = "name")
//    @NotNull
//    @NotBlank
    private String name;

    @Column(name = "email")
//    @Email
//    @NonNull
//    @NotBlank
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "city")
//    @NotBlank
//    @NotNull
    private String city;

    @Column(name = "address")
    private String address;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "contributor")
    private List<Book> contributedBooks;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "currentKeeper")
    private List<Book> borrowedBooks;
}
