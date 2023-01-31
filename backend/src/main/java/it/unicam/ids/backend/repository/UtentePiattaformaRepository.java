package it.unicam.ids.backend.repository;

import it.unicam.ids.backend.entity.UtentePiattaforma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtentePiattaformaRepository extends JpaRepository<UtentePiattaforma, String> {
}
