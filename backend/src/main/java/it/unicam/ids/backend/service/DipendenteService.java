package it.unicam.ids.backend.service;

import it.unicam.ids.backend.entity.Dipendente;
import it.unicam.ids.backend.id.DipendenteID;
import it.unicam.ids.backend.repository.DipendenteRepository;
import it.unicam.ids.backend.repository.UtentePiattaformaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DipendenteService {

    private final DipendenteRepository dipendenteRepository;
    private final UtentePiattaformaRepository utentePiattaformaRepository;


    public DipendenteService(
            DipendenteRepository dipendenteRepository,
            UtentePiattaformaRepository utentePiattaformaRepository
    ) {
        this.dipendenteRepository = dipendenteRepository;
        this.utentePiattaformaRepository = utentePiattaformaRepository;
    }


    public List<Dipendente> getAllDipendente() {
        return dipendenteRepository.findAll();
    }

    public Dipendente getDipendente(DipendenteID id) {
        return dipendenteRepository.findById(id).orElse(null);
    }

    public Dipendente addDipendente(Dipendente dipendente) {
        utentePiattaformaRepository.save(dipendente.getUtentePiattaforma());
        return dipendenteRepository.save(dipendente);
    }

    public Dipendente updateDipendente(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

    public void deleteDipendente(DipendenteID id) {
        dipendenteRepository.deleteById(id);
    }
}
