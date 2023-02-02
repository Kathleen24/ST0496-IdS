package it.unicam.ids.backend.repository;

import it.unicam.ids.backend.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    /**
     * Questa query restituisce i clienti iscritti alla piattaforma nel intervallo
     * di tempo inserito come parametro.
     *
     * @param start la data di inizio per eseguire il controllo
     * @param end la data di fine per eseguire il controllo
     *
     * @return la lista di clienti
     */
    @Query("SELECT c FROM Cliente c WHERE c.dataIscrizionePiattaforma BETWEEN :start AND :end")
    List<Cliente> findClientiNellIntervalloDiTempo(@Param("start") LocalDate start, @Param("end") LocalDate end);

    /**
     * Questa query restituisce i clienti iscritti a un programma fedeltà nel intervallo
     * di tempo inserito come parametri.
     *
     * @param start la data di inizio per eseguire il controllo
     * @param end la data di fine per eseguire il controllo
     * @param programmaFedeltaID ID del programma fedeltà.
     *
     * @return la lista di clienti.
     */
    @Query("SELECT c FROM Cliente c, ProgrammaFedeltaDelCliente pfdc " +
            "WHERE pfdc.programmaFedelta.id = :programmaFedeltaID " +
            "AND pfdc.tessera = c.tessera " +
            "AND pfdc.dataIscrizione BETWEEN :start AND :end")
    List<Cliente> findClientiIscrittiAlProgrammaFedeltaNellIntervalloDiTempo(
            @Param("start") LocalDate start,
            @Param("end") LocalDate end,
            @Param("programmaFedeltaID") Integer programmaFedeltaID
    );
}