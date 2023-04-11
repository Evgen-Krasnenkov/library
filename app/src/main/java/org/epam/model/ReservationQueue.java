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
@Table(name = "reservation_queue")
@Data
public class ReservationQueue {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservationid")
    private Long reservationId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bookid")
    private Book book;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid")
    private User user;

    @Column(name = "reservation_date")
    private LocalDate reservationDate;
}
