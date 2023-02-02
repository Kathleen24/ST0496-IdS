package it.unicam.ids.backend.service;

import it.unicam.ids.backend.entity.Coalizione;
import it.unicam.ids.backend.repository.AziendaRepository;
import it.unicam.ids.backend.repository.CoalizioneRepository;
import it.unicam.ids.backend.repository.ProgrammaFedeltaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CoalizioneService {

    private final CoalizioneRepository coalizioneRepository;
    private final ProgrammaFedeltaRepository programmaFedeltaRepository;
    private final AziendaRepository aziendaRepository;


    public CoalizioneService(
            CoalizioneRepository coalizioneRepository,
            ProgrammaFedeltaRepository programmaFedeltaRepository,
            AziendaRepository aziendaRepository
    ) {
        this.coalizioneRepository = coalizioneRepository;
        this.programmaFedeltaRepository = programmaFedeltaRepository;
        this.aziendaRepository = aziendaRepository;
    }


    public List<Coalizione> getAllCoalizioni() {
        return coalizioneRepository.findAll();
    }

    public Coalizione getCoalizione(Integer id) {
        return coalizioneRepository.findById(id).orElse(null);
    }

    public Coalizione addCoalizione(Integer pfID, Integer aziendaID, LocalDate dataInizio, LocalDate dataFine) {
        return coalizioneRepository.save(new Coalizione(
                programmaFedeltaRepository.findById(pfID).orElseThrow(),
                aziendaRepository.findById(aziendaID).orElseThrow(),
                dataInizio, dataFine
        ));
    }

    public Coalizione updateDataFine(Integer id, LocalDate dataFine) {
        Coalizione coalizione = getCoalizione(id);
        coalizione.setDataFine(dataFine);
        return coalizioneRepository.save(coalizione);
    }

    public void deleteCoalizione(Integer id) {
        if (getCoalizione(id).getStato().equals(Coalizione.Stato.ACCETTATA_INATTIVA) ||
                getCoalizione(id).getStato().equals(Coalizione.Stato.INATTESA_INATTIVA)) {
            coalizioneRepository.deleteById(id);
        }
        else System.out.println("Non puoi eseguire questa operazione");
    }

    public void accettaCoalizione(Integer id) {
        Coalizione coalizione = getCoalizione(id);
        if (coalizione.isInAttesaEAccettabile()) {
            coalizione.setStato(Coalizione.Stato.ACCETTATA_INATTIVA);
            coalizioneRepository.save(coalizione);
        }
        else System.out.println("Non puoi eseguire questa operazione");
    }

    public void rifiutaCoalizione(Integer id) {
        Coalizione coalizione = getCoalizione(id);
        if (coalizione.isInAttesaEAccettabile()) {
            coalizione.setStato(Coalizione.Stato.RIFIUTATA_INATTIVA);
            coalizioneRepository.save(coalizione);
        }
        else System.out.println("Non puoi eseguire questa operazione");
    }
}
