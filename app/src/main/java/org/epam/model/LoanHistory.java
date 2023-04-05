package org.epam.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "loan_history")
@Data
public class LoanHistory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LoanID")
    private Long loanId;

    @ManyToOne
    @JoinColumn(name = "BookID")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    @Column(name = "Loan_Date")
    private LocalDate loanDate;

    @Column(name = "Due_Date")
    private LocalDate dueDate;
}
