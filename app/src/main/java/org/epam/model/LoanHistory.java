package org.epam.model;

import jakarta.persistence.FetchType;
import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "loan_history")
@Data
public class LoanHistory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loanid")
    private Long loanId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bookid")
    private Book book;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid")
    private User user;

    @Column(name = "loan_date")
    private LocalDate loanDate;

    @Column(name = "due_date")
    private LocalDate dueDate;
}
