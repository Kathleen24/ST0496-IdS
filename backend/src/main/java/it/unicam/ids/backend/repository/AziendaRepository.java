package it.unicam.ids.backend.repository;

import it.unicam.ids.backend.entity.Azienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AziendaRepository extends JpaRepository<Azienda, Integer> {
}
