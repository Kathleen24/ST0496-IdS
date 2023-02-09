package it.unicam.ids.backend.repository;

import it.unicam.ids.backend.entity.Recensione;
import it.unicam.ids.backend.id.RecensioneID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecensioneRepository extends JpaRepository<Recensione, RecensioneID> {
}
