package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Abbonamento;
import it.unicam.ids.backend.entity.Azienda;
import it.unicam.ids.backend.entity.Cliente;
import it.unicam.ids.backend.entity.Stabilimento;
import it.unicam.ids.backend.service.AziendaService;
import it.unicam.ids.backend.util.EntityValidator;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/azienda")
public class AziendaController implements EntityValidator<Azienda> {

    private final AziendaService aziendaService;


    public AziendaController(AziendaService aziendaService) {
        this.aziendaService = aziendaService;
    }

    public void validateEntity(Azienda azienda) {
        if (azienda == null)
            throw new NullPointerException("L'oggetto azienda è nullo");
        if (azienda.getNomeAzienda() == "null")
            throw new IllegalArgumentException("Il nome dell'azienda non puo essere nullo");
    }

    @GetMapping("/all")
    public List<Azienda> getAllAziende() {
        return aziendaService.getAllAziende();
    }

    @GetMapping("/{id}")
    public Azienda getAzienda(@PathVariable Integer id) {
        return aziendaService.getAzienda(id);
    }

    @PostMapping("/add")
    public Azienda addAzienda(
            @RequestParam String nome,
            @RequestParam String terminiLegali,
            @RequestParam(defaultValue = "") String infoAttivita,
            @RequestParam(defaultValue = "") String link
    ) {
        return aziendaService.addAzienda(nome, terminiLegali, infoAttivita, link);
    }

    @PostMapping("/update")
    public Azienda updateAzienda(@RequestBody Azienda azienda) {
        return aziendaService.updateAzienda(azienda);
    }

    /**
     * Restituisce le aziende iscritte alla piattaforma nel intervallo
     * di tempo inserito come parametro.
     *
     * @param start - la data di inizio per eseguire il controllo
     * @param end   - la data di fine per eseguire il controllo
     * @return la lista di aziende
     */
    //TODO nome
    public List<Azienda> findAziendeNellIntervalloDiTempo(Date start, Date end) {
        return aziendaService.findAziendeNellIntervalloDiTempo(start, end);
    }

    /**
     * Restituisce tutti i clienti iscritti ad almeno un programma fedeltà dell' azienda.
     * @param aziendaID - l'ID dell'azienda.
     * @return - la lista di Clienti.
     */
    //TODO nome
    public List<Cliente> getClientiAfiiliati(@RequestParam Integer aziendaID) {
        return aziendaService.getClientiAffiliati(aziendaID);
    }

    /**
     * Restituisce tutti gli stabilimenti di un' azienda.
     * @param aziendaID - l'ID dell'azienda.
     * @return - la lista di Stabilimenti.
     */
    //TODO nome
    public List<Stabilimento> getStabilimenti(Integer aziendaID) {
        return aziendaService.getStabilimenti(aziendaID);
    }

    @DeleteMapping("/{id}")
    public void deleteAzienda(@PathVariable Integer id) {
        aziendaService.deleteAzienda(id);
    }
}
