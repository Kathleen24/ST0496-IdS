package it.unicam.ids.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DipendeteService {
    @Autowired
    private DipendeteRepository dipendeteRepository;

    public List<Dipendete> getAllDipendete() {
        return dipendeteRepository.findAll();
    }

    public Dipendete getDipendete(String nomeUtente) {
        Optional<Dipendete> dipendete = this.dipendeteRepository.findById(nomeUtente);
        return dipendete.orElse(null);
    }

    public void addDipendete(Dipendete dipendete) {
        dipendeteRepository.save(dipendete);
    }

    public void updateDipendete(String nomeUtente, Dipendete dipendete) {
        dipendeteRepository.save(dipendete);
    }

    public void deleteDipendete(String nomeUtente) {
        dipendeteRepository.deleteById(nomeUtente);
    }
}
