package it.unicam.ids.backend.repository;

import it.unicam.ids.backend.entity.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, String> {
}
