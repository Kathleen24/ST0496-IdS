package it.unicam.ids.backend;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Azienda> azienda = this.aziendaRepository.findById(id);
        return azienda.orElse(null);
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
