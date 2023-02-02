package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Coalizione;
import it.unicam.ids.backend.service.AziendaService;
import it.unicam.ids.backend.service.CoalizioneService;
import it.unicam.ids.backend.service.ProgrammaFedeltaService;
import it.unicam.ids.backend.util.EntityValidator;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/coalizioni")
public class CoalizioneController implements EntityValidator<Coalizione> {

    private final CoalizioneService coalizioneService;
    private final ProgrammaFedeltaService programmaFedeltaService;
    private final AziendaService aziendaService;


    public CoalizioneController(
            CoalizioneService coalizioneService,
            ProgrammaFedeltaService programmaFedeltaService,
            AziendaService aziendaService
    ) {
        this.coalizioneService = coalizioneService;
        this.programmaFedeltaService = programmaFedeltaService;
        this.aziendaService = aziendaService;
    }

    public void validateEntity(Coalizione coalizione) {
        if (coalizione==null)
            throw new NullPointerException("L'oggetto coalizione è nullo");
        if(programmaFedeltaService.getProgrammaFedelta(coalizione.getProgrammaFedelta().getId())==null)
            throw new IllegalArgumentException("Il programma fedeltà inserito non è esistente");
        if(aziendaService.getAzienda(coalizione.getAziendaDestinataria().getId())==null)
            throw new IllegalArgumentException("L'azienda destinataria inserita non è esistente");
        if(aziendaService.getAzienda(coalizione.getAziendaMittente().getId())==null)
            throw new IllegalArgumentException("L'azienda mittente inserita non è esistente");
        if(coalizione.getDataInizio().before(coalizione.getDataFine()))
            throw new IllegalArgumentException("La data di inizio deve essere prima della data di fine");
    }

    @GetMapping("/all")
    public List<Coalizione> getAllCoalizioni() {
        return coalizioneService.getAllCoalizioni();
    }

    @GetMapping("/{id}")
    public Coalizione getCoalizione(@PathVariable Integer id) {
        return coalizioneService.getCoalizione(id);
    }

    @PostMapping("/add")
    public Coalizione addCoalizione(
            @RequestParam Integer pfID, @RequestParam Integer aziendaID,
            @RequestParam LocalDate dataInizio, @RequestParam LocalDate dataFine
    ) {
        return coalizioneService.addCoalizione(pfID, aziendaID, dataInizio, dataFine);
    }

    @PostMapping("/{id}/updateDataFine")
    public Coalizione updateDataFine(@PathVariable Integer id, @RequestParam LocalDate dataFine) {
        return coalizioneService.updateDataFine(id, dataFine);
    }

    @DeleteMapping("/{id}")
    public void deleteCoalizione(@PathVariable Integer id) {
        coalizioneService.deleteCoalizione(id);
    }

    /**
     * Cambia lo stato della coalizione in {@link Coalizione.Stato#ACCETTATA_INATTIVA ACCETTATA_INATTIVA} se è possibile
     *
     * @param id l'id della coalizione
     */
    @PatchMapping("/{id}/accept")
    public void accettaCoalizione(@PathVariable Integer id) {
        coalizioneService.accettaCoalizione(id);
    }

    /**
     * Cambia lo stato della coalizione in {@link Coalizione.Stato#RIFIUTATA_INATTIVA RIFIUTATA_INATTIVA} se è possibile
     *
     * @param id l'id della coalizione
     */
    @PatchMapping("/{id}/reject")
    public void rifiutaCoalizione(@PathVariable Integer id) {
        coalizioneService.rifiutaCoalizione(id);
    }
}
