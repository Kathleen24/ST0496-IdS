package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Abbonamento;
import it.unicam.ids.backend.entity.Azienda;
import it.unicam.ids.backend.service.AziendaService;
import it.unicam.ids.backend.util.EntityValidator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/azienda")
public class AziendaController implements EntityValidator<Azienda> {

    private final AziendaService aziendaService;


    public AziendaController(AziendaService aziendaService) {
        this.aziendaService = aziendaService;
    }

    public void validateEntity(Azienda azienda) {
        if (azienda==null)
            throw new NullPointerException("L'oggetto azienda è nullo");
        if(azienda.getNomeAzienda()=="null")
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
    public void addAzienda(
            @RequestParam String nome,
            @RequestParam String terminiLegali,
            @RequestParam(defaultValue = "") String infoAttivita,
            @RequestParam(defaultValue = "") String link
    ) {
        Azienda azienda = aziendaService.addAzienda(nome, terminiLegali, infoAttivita, link);
    }

    public void updateAzienda(Azienda azienda) {
        aziendaService.updateAzienda(azienda);
    }

    @DeleteMapping("/{id}")
    public void deleteAzienda(@PathVariable Integer id) {
        aziendaService.deleteAzienda(id);
    }
}
