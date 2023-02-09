package it.unicam.ids.backend.service;

import it.unicam.ids.backend.entity.Bonus;
import it.unicam.ids.backend.entity.Dipendente;
import it.unicam.ids.backend.entity.Recensione;
import it.unicam.ids.backend.id.DipendenteID;
import it.unicam.ids.backend.id.RecensioneID;
import it.unicam.ids.backend.repository.RecensioneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecensioneService {
    private final RecensioneRepository recensioneRepository;

    public RecensioneService(RecensioneRepository recensioneRepository) {
        this.recensioneRepository = recensioneRepository;
    }

    public List<Recensione> getAllRecensioni() {
        return recensioneRepository.findAll();
    }

    public Recensione getRecensione(RecensioneID id) {
        return recensioneRepository.findById(id).orElse(null);
    }

    public Recensione addRecensione(Recensione recensione) {
        return recensioneRepository.save(recensione);
    }

    public Recensione updateRecensione(Recensione recensione) {
        return recensioneRepository.save(recensione);
    }

    public void deleteRecensione(RecensioneID id) {
        recensioneRepository.deleteById(id);
    }
}
