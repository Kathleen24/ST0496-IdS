package it.unicam.ids.backend.repository;

import it.unicam.ids.backend.entity.Abbonamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbbonamentoRepository extends JpaRepository<Abbonamento, Integer> {
    /**
     * Questa query restituirà tutti gli abbonamenti filtrati in base allo stato del parametro "attivo".
     * @param attivo - attivo = true/false.
     * @return - Restiuirà una lista di Abbonamenti attivi o non attivi.
     */
    @Query("SELECT a FROM Abbonamento a WHERE a.attivo = :attivo")
    List<Abbonamento> getAllAbbonamentiAttivi(@Param("attivo") Boolean attivo);
}
