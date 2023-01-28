package it.unicam.ids.backend.repository;

import it.unicam.ids.backend.entity.PianoTariffario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PianoTariffarioRepository extends JpaRepository<PianoTariffario, Integer> {
}