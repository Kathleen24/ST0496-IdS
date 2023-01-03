package it.unicam.ids.backend.service;

import it.unicam.ids.backend.entity.Dipendente;
import it.unicam.ids.backend.repository.DipendenteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DipendenteService {

    private final DipendenteRepository dipendenteRepository;


    public DipendenteService(DipendenteRepository dipendenteRepository) {
        this.dipendenteRepository = dipendenteRepository;
    }


    public List<Dipendente> getAllDipendente() {
        return dipendenteRepository.findAll();
    }

    public Dipendente getDipendente(String nomeUtente) {
        Optional<Dipendente> dipendente = this.dipendenteRepository.findById(nomeUtente);
        return dipendente.orElse(null);
    }

    public void addDipendente(Dipendente dipendente) {
        dipendenteRepository.save(dipendente);
    }

    public void updateDipendente(Dipendente dipendente) {
        dipendenteRepository.save(dipendente);
    }

    public void deleteDipendente(String nomeUtente) {
        dipendenteRepository.deleteById(nomeUtente);
    }
}
