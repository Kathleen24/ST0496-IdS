package it.unicam.ids.backend.service;

import it.unicam.ids.backend.entity.Azienda;
import it.unicam.ids.backend.entity.Cliente;
import it.unicam.ids.backend.entity.Stabilimento;
import it.unicam.ids.backend.repository.AziendaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AziendaService {

    private final AziendaRepository aziendaRepository;


    public AziendaService(AziendaRepository aziendaRepository) {
        this.aziendaRepository = aziendaRepository;
    }


    public List<Azienda> getAllAziende() {
        return aziendaRepository.findAll();
    }

    /**
     * Restituisce le aziende iscritte alla piattaforma nel intervallo
     * di tempo inserito come parametro.
     *
     * @param start la data di inizio per eseguire il controllo
     * @param end la data di fine per eseguire il controllo
     *
     * @return la lista di aziende
     */
    public List<Azienda> findAziendeNellIntervalloDiTempo(LocalDate start, LocalDate end){
        return aziendaRepository.findAziendeNellIntervalloDiTempo(start, end);
    }

    /**
     * Restituisce tutti i clienti iscritti ad almeno un programma fedeltà dell'azienda.
     *
     * @param aziendaID l'ID dell'azienda.
     * @return la lista di clienti.
     */
    public List<Cliente> getClientiAffiliati(Integer aziendaID){
        return aziendaRepository.getClientiAffiliati(aziendaID);
    }


    /**
     * Restituisce tutti gli stabilimenti di un'azienda.
     *
     * @param aziendaID l'ID dell'azienda
     * @return la lista di stabilimenti
     */
    public List<Stabilimento> getStabilimenti(Integer aziendaID){
        return aziendaRepository.getStabilimenti(aziendaID);
    }

    public Azienda getAzienda(Integer id) {
        return aziendaRepository.findById(id).orElse(null);
    }

    public Azienda addAzienda(String nome, String terminiLegali, String infoAttivita, String link) {
        return aziendaRepository.save(new Azienda(nome, terminiLegali, infoAttivita, link));
    }

    public Azienda updateAzienda(Azienda azienda) {
        return aziendaRepository.save(azienda);
    }

    public void deleteAzienda(Integer id) {
        aziendaRepository.deleteById(id);
    }
}
