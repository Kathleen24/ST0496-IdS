package it.unicam.ids.backend.service;

import it.unicam.ids.backend.entity.AmministratorePiattaforma;
import it.unicam.ids.backend.repository.AmministratorePiattaformaRepository;
import org.springframework.stereotype.Service;

@Service
public class AmministratorePiattaformaService {

    private final AmministratorePiattaformaRepository amministratorePiattaformaRepository;


    public AmministratorePiattaformaService(AmministratorePiattaformaRepository amministratorePiattaformaRepository) {
        this.amministratorePiattaformaRepository = amministratorePiattaformaRepository;
    }


    public AmministratorePiattaforma getAmministratorePiattaforma(Integer username) {
        return amministratorePiattaformaRepository.findById(username).orElse(null);
    }

    public AmministratorePiattaforma addAmministratorePiattaforma(String username, String password) {
        return amministratorePiattaformaRepository.save(new AmministratorePiattaforma(username, password));
    }

    public void updateAmministratorePiattaforma(String username, String password) {
        deleteAmministratorePiattaforma(username.hashCode());
        addAmministratorePiattaforma(username, password);
    }

    public void deleteAmministratorePiattaforma(Integer username) {
        amministratorePiattaformaRepository.deleteById(username);
    }
}
