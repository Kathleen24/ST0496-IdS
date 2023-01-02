package it.unicam.ids.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammaFedeltaRepository extends JpaRepository<ProgrammaFedelta,ProgrammaFedeltaID> {
}
