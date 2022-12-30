package it.unicam.ids.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AziendaService {
    @Autowired
    private AziendaRepository aziendaRepository;

    public List<Azienda> getAllAziende() {
        return aziendaRepository.findAll();
    }

    public Azienda getAzienda(Integer id) {
        Optional<Azienda> azienda = this.aziendaRepository.findById(id);
        if (azienda.isPresent()) {
            return azienda.get();
        } else {
            return null;
        }
    }

    public void addAzienda(Azienda azienda) {
        aziendaRepository.save(azienda);
    }

    public void updateAzienda(Integer id, Azienda azienda) {
        aziendaRepository.save(azienda);
    }

    public void deleteAzienda(Integer id) {
        aziendaRepository.deleteById(id);
    }
}
