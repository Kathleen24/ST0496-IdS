package it.unicam.ids.backend.repository;

import it.unicam.ids.backend.entity.Cliente;
import it.unicam.ids.backend.entity.ProgrammaFedelta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ProgrammaFedeltaRepository extends JpaRepository<ProgrammaFedelta, Integer> {
    /**
     * Questa query restituisce la lista di programmi fedeltà dell'azienda che viene inserita tramite parametro.
     *
     * @param aziendaID - ID dell'azienda
     *
     * @return la lista dei programmi fedeltà
     */
    @Query("SELECT pf FROM ProgrammaFedelta pf, ProgrammaFedeltaDelCliente pfdc " +
            "WHERE pf.azienda.id = :aziendaID ")
   public List<ProgrammaFedelta> findProgrammiFedeltaDellAzienda(@Param("aziendaID") Integer aziendaID);
}

