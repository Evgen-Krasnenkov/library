package org.epam.dao;

import org.epam.model.ReservationQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationQueueRepository extends JpaRepository<ReservationQueue, Long> {
}
