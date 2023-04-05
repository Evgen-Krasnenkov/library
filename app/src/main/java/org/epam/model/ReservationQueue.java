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
@Table(name = "reservation_queue")
@Data
public class ReservationQueue {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReservationID")
    private Long reservationId;

    @ManyToOne
    @JoinColumn(name = "BookID")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    @Column(name = "Reservation_Date")
    private LocalDate reservationDate;
}
