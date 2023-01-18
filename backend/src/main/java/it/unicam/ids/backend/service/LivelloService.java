package it.unicam.ids.backend.service;

import it.unicam.ids.backend.entity.Livello;
import it.unicam.ids.backend.entity.Livello;
import it.unicam.ids.backend.id.LivelloID;
import it.unicam.ids.backend.repository.LivelloRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequestMapping("/livelli")
public class LivelloService {

    private final LivelloRepository livelloRepository;


    public LivelloService(LivelloRepository livelloRepository) {
        this.livelloRepository = livelloRepository;
    }


    @GetMapping("/all")
    public List<Livello> getAllLivelli() {
        return livelloRepository.findAll();
    }

    public Livello getLivello(LivelloID id) {
        Optional<Livello> livello = this.livelloRepository.findById(id);
        return livello.orElse(null);
    }

    public void addLivello(Livello livello) {
        livelloRepository.save(livello);
    }

    public void updateLivello(Livello livello) {
        livelloRepository.save(livello);
    }

    public void deleteLivello(LivelloID id) {
        livelloRepository.deleteById(id);
    }
}
