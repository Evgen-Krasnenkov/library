package org.epam.dao;

import org.epam.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepo extends JpaRepository<Genre, Long> {
}
