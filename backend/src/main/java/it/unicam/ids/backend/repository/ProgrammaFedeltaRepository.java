package it.unicam.ids.backend.repository;

import it.unicam.ids.backend.entity.ProgrammaFedelta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammaFedeltaRepository extends JpaRepository<ProgrammaFedelta, Integer> {
}
