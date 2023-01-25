package it.unicam.ids.backend.service;

import it.unicam.ids.backend.entity.Azienda;
import it.unicam.ids.backend.repository.AziendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AziendaService {

    private final AziendaRepository aziendaRepository;


    public AziendaService(AziendaRepository aziendaRepository) {
        this.aziendaRepository = aziendaRepository;
    }


    public List<Azienda> getAllAziende() {
        return aziendaRepository.findAll();
    }

    public Azienda getAzienda(Integer id) {
        return aziendaRepository.findById(id).orElse(null);
    }

    public void addAzienda(Azienda azienda) {
        aziendaRepository.save(azienda);
    }

    public void updateAzienda(Azienda azienda) {
        aziendaRepository.save(azienda);
    }

    public void deleteAzienda(Integer id) {
        aziendaRepository.deleteById(id);
    }
}
