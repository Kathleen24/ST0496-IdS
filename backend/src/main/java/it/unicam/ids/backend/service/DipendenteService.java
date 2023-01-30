package it.unicam.ids.backend.service;

import it.unicam.ids.backend.entity.Dipendente;
import it.unicam.ids.backend.id.DipendenteID;
import it.unicam.ids.backend.repository.DipendenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DipendenteService {

    private final DipendenteRepository dipendenteRepository;


    public DipendenteService(DipendenteRepository dipendenteRepository) {
        this.dipendenteRepository = dipendenteRepository;
    }


    public List<Dipendente> getAllDipendente() {
        return dipendenteRepository.findAll();
    }

    public Dipendente getDipendente(DipendenteID id) {
        return dipendenteRepository.findById(id).orElse(null);
    }

    public void addDipendente(Dipendente dipendente) {
        dipendenteRepository.save(dipendente);
    }

    public void updateDipendente(Dipendente dipendente) {
        dipendenteRepository.save(dipendente);
    }

    public void deleteDipendente(DipendenteID id) {
        dipendenteRepository.deleteById(id);
    }
}
