package it.unicam.ids.backend.repository;

import it.unicam.ids.backend.entity.Dipendente;
import it.unicam.ids.backend.id.DipendenteID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, DipendenteID> {
}
