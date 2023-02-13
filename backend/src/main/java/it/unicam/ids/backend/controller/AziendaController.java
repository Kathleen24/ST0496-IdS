package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Azienda;
import it.unicam.ids.backend.entity.Cliente;
import it.unicam.ids.backend.entity.ProgrammaFedelta;
import it.unicam.ids.backend.entity.Stabilimento;
import it.unicam.ids.backend.service.AziendaService;
import it.unicam.ids.backend.util.EntityValidator;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/aziende")
public class AziendaController implements EntityValidator<Azienda> {

    private final AziendaService aziendaService;


    public AziendaController(AziendaService aziendaService) {
        this.aziendaService = aziendaService;
    }


    @Override
    public void validateEntity(Azienda azienda) {
        if (azienda == null)
            throw new NullPointerException("L'oggetto azienda è nullo");
        if (azienda.getNomeAzienda() == null)
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

    @DeleteMapping("/{id}")
    public void deleteAzienda(@PathVariable Integer id) {
        aziendaService.deleteAzienda(id);
    }

    /**
     * Restituisce le aziende iscritte alla piattaforma nel intervallo
     * di tempo inserito come parametro.
     *
     * @param start la data di inizio per eseguire il controllo
     * @param end la data di fine per eseguire il controllo
     * @return la lista di aziende
     */
    @GetMapping("/findInIntervallo")
    public List<Azienda> findAziendeNellIntervalloDiTempo(@RequestParam LocalDate start, @RequestParam LocalDate end) {
        return aziendaService.findAziendeNellIntervalloDiTempo(start, end);
    }

    /**
     * Restituisce tutti i clienti iscritti ad almeno un programma fedeltà dell'azienda.
     *
     * @param id l'ID dell'azienda
     * @return la lista di Clienti
     */
    @GetMapping("/{id}/clienti")
    public List<Cliente> getClientiAffiliati(@PathVariable Integer id) {
        return aziendaService.getClientiAffiliati(id);
    }

    /**
     * Restituisce tutti gli stabilimenti di un'azienda.
     *
     * @param id l'ID dell'azienda
     * @return la lista di Stabilimenti
     */
    @GetMapping("/{id}/stabilimenti")
    public List<Stabilimento> getStabilimenti(@PathVariable Integer id) {
        return aziendaService.getStabilimenti(id);
    }

    /**
     * Restituisce tutti i programmi fedeltà di un'azienda.
     *
     * @param id l'ID dell'azienda
     * @return la lista di Programmi Fedeltà
     */
    @GetMapping("/{id}/programmiFedelta")
    public List<ProgrammaFedelta> getAllProgrammiFedeltaOf(@PathVariable Integer id) {
        return aziendaService.getAllProgrammiFedeltaOf(id);
    }
}
