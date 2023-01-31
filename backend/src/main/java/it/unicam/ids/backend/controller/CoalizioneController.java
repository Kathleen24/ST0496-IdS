package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Coalizione;
import it.unicam.ids.backend.service.AziendaService;
import it.unicam.ids.backend.service.CoalizioneService;
import it.unicam.ids.backend.service.ProgrammaFedeltaService;
import it.unicam.ids.backend.util.EntityValidator;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static it.unicam.ids.backend.entity.Coalizione.Stato.ACCETTATA_INATTIVA;

@RestController
public class CoalizioneController implements EntityValidator<Coalizione> {

    private final CoalizioneService coalizioneService;
    private ProgrammaFedeltaService programmaFedeltaService;
    private AziendaService aziendaService;


    public CoalizioneController(CoalizioneService aziendaServiceDB, ProgrammaFedeltaService programmaFedeltaService, AziendaService aziendaService) {
        this.coalizioneService = aziendaServiceDB;
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

    public List<Coalizione> getAllCoalizioni() {
        return coalizioneService.getAllCoalizioni();
    }

    public Coalizione getCoalizione(Integer id) {
        return coalizioneService.getCoalizione(id);
    }

    public void addCoalizione(Coalizione coalizione) {
        coalizioneService.addCoalizione(coalizione);
    }

    public void updateCoalizione(Coalizione coalizione) {
        coalizioneService.updateCoalizione(coalizione);
    }

    public void deleteCoalizione(Integer id) {
        if (getCoalizione(id).getStato().equals(ACCETTATA_INATTIVA) ||
                getCoalizione(id).getStato().equals(Coalizione.Stato.INATTESA_INATTIVA))
            coalizioneService.deleteCoalizione(id);
        else
            System.out.println("Non puoi eseguire questa operazione");
    }

    /**
     * Determina se la coalizione è nello stato INATTESA_INATTIVA
     * @param id
     * @return true se ci si trova. false altrimenti
     */
    public boolean isInAttesaEAccettabile(Integer id) {
        return getCoalizione(id).getStato().equals(Coalizione.Stato.INATTESA_INATTIVA);
    }

    /**
     * Cambia lo stato della coalizione in ACCETTATA_INATTIVA se è possibile
     * @param id
     */
    public void accettaCoalizione(Integer id) {
        if (isInAttesaEAccettabile(id)) {
            getCoalizione(id).setStato(Coalizione.Stato.ACCETTATA_INATTIVA);
            updateCoalizione(getCoalizione(id));
            //non ho capito come cambia update da add
        }
        else
            System.out.println("Non puoi eseguire questa operazione");
    }

    /**
     * Cambia lo stato della coalizione in RIFIUTATA_INATTIVA se è possibile
     * @param id
     */
    public void rifiutaCoalizione(Integer id) {
        if (isInAttesaEAccettabile(id)) {
            getCoalizione(id).setStato(Coalizione.Stato.RIFIUTATA_INATTIVA);
            updateCoalizione(getCoalizione(id));
            //non ho capito come cambia update da add
        }
        else
            System.out.println("Non puoi eseguire questa operazione");
    }
}
