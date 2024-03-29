package it.unicam.ids.backend.repository;

import it.unicam.ids.backend.entity.Azienda;
import it.unicam.ids.backend.entity.Cliente;
import it.unicam.ids.backend.entity.ProgrammaFedelta;
import it.unicam.ids.backend.entity.Stabilimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AziendaRepository extends JpaRepository<Azienda, Integer> {

    /**
     * Questa query restituisce le aziende iscritte alla piattaforma nel intervallo
     * di tempo inserito come parametro.
     *
     * @param start la data di inizio per eseguire il controllo
     * @param end la data di fine per eseguire il controllo
     * @return la lista di aziende
     */
    @Query("SELECT a " +
            "FROM Azienda a " +
            "WHERE a.dataIscrizionePiattaforma " +
            "BETWEEN :start AND :end")
    List<Azienda> findAziendeNellIntervalloDiTempo(@Param("start") LocalDate start, @Param("end") LocalDate end);

    /**
     * Questa query restituisce tutti i clienti iscritti ad almeno un programma fedeltà dell'azienda
     *
     * @param aziendaID l'ID dell'azienda
     * @return la lista di clienti
     */
    @Query("SELECT DISTINCT cliente " +
            "FROM Cliente cliente , ProgrammaFedelta programmaFedelta, ProgrammaFedeltaDelCliente programmaFedeltaDelCliente " +
            "WHERE :aziendaID = programmaFedelta.azienda.id " +
            "AND programmaFedelta.id = programmaFedeltaDelCliente.programmaFedeltaID " +
            "AND cliente.tessera = programmaFedeltaDelCliente.tessera")
    List<Cliente> getClientiAffiliati(@Param("aziendaID") Integer aziendaID);

    /**
     * Questa query restituisce tutti gli stabilimenti di un'azienda.
     *
     * @param aziendaID l'ID dell'azienda
     * @return la lista di stabilimenti
     */
    @Query("SELECT stabilimento " +
            "FROM Stabilimento stabilimento " +
            "WHERE stabilimento.aziendaID = :aziendaID")
    List<Stabilimento> getStabilimenti(@Param("aziendaID") Integer aziendaID);

    /**
     * Questa query restituisce la lista di programmi fedeltà dell'azienda che viene inserita tramite parametro.
     *
     * @param aziendaID l'ID dell'azienda
     * @return la lista dei programmi fedeltà
     */
    @Query("SELECT pf FROM ProgrammaFedelta pf, ProgrammaFedeltaDelCliente pfdc " +
            "WHERE pf.azienda.id = :aziendaID")
    List<ProgrammaFedelta> findProgrammiFedeltaDellAzienda(@Param("aziendaID") Integer aziendaID);
}
