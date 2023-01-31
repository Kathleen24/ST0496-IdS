package it.unicam.ids.backend.repository;

import it.unicam.ids.backend.entity.Azienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.util.List;

@Repository
public interface AziendaRepository extends JpaRepository<Azienda, Integer> {

    /**
     * Questa query restituisce le aziende iscritte alla piattaforma nel intervallo
     * di tempo inserito come parametro.
     *
     * @param start - la data di inizio per eseguire il controllo
     * @param end - la data di fine per eseguire il controllo
     *
     * @return la lista di aziende
     */
    @Query("SELECT a FROM Azienda a WHERE a.dataIscrizionePiattaforma BETWEEN :start AND :end")
    List<Azienda> findAziendeNellIntervalloDiTempo(@Param("start") Date start, @Param("end") Date end);
}
