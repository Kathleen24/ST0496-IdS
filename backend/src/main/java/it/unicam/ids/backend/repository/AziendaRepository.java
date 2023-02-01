package it.unicam.ids.backend.repository;

import it.unicam.ids.backend.entity.Azienda;
import it.unicam.ids.backend.entity.Cliente;
import it.unicam.ids.backend.entity.Stabilimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
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
    @Query( "SELECT a " +
            "FROM Azienda a " +
            "WHERE a.dataIscrizionePiattaforma " +
            "BETWEEN :start AND :end")
    List<Azienda> findAziendeNellIntervalloDiTempo(@Param("start") Date start, @Param("end") Date end);

    /**
     * Questa query restituisce tutti i clienti iscritti ad almeno un programma
     * fedeltà dell' azienda.
     * @param aziendaID - l'ID dell'azienda.
     * @return - la lista di Clienti.
     */
    @Query( "SELECT DISTINCT  cliente " +
            "FROM Cliente cliente , ProgrammaFedelta programmaFedelta, ProgrammaFedeltaDelCliente programmaFedeltaDelCliente " +
            "WHERE :aziendaID = programmaFedelta.azienda.id " +
            "AND programmaFedelta.id = programmaFedeltaDelCliente.programmaFedeltaID " +
            "AND cliente.tessera = programmaFedeltaDelCliente.tessera")
    List<Cliente> getClientiAffiliati(@Param("aziendaID") Integer aziendaID);

    /**
     * Questa query restituisce tutti gli stabilimenti di un' azienda.
     * @param aziendaID - l'ID dell'azienda.
     * @return - la lista di Stabilimenti.
     */
    @Query("SELECT stabilimento " +
            "FROM Stabilimento stabilimento " +
            "WHERE stabilimento.aziendaID = :aziendaID")
    List<Stabilimento> getStabilimenti(@Param("aziendaID") Integer aziendaID);
}
