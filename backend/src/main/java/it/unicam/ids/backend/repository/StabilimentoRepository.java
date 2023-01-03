package it.unicam.ids.backend.repository;

import it.unicam.ids.backend.entity.Stabilimento;
import it.unicam.ids.backend.id.StabilimentoID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StabilimentoRepository extends JpaRepository<Stabilimento, StabilimentoID> {
}
