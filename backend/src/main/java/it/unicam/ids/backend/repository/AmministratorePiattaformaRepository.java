package it.unicam.ids.backend.repository;

import it.unicam.ids.backend.entity.AmministratorePiattaforma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmministratorePiattaformaRepository extends JpaRepository<AmministratorePiattaforma, Integer> {
}
