package it.unicam.ids.backend.service;

import it.unicam.ids.backend.entity.Coalizione;
import it.unicam.ids.backend.repository.CoalizioneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoalizioneService {

    private final CoalizioneRepository coalizioneRepository;


    public CoalizioneService(CoalizioneRepository coalizioneRepository) {
        this.coalizioneRepository = coalizioneRepository;
    }


    public List<Coalizione> getAllCoalizioni() {
        return coalizioneRepository.findAll();
    }

    public Coalizione getCoalizione(Integer id) {
        return coalizioneRepository.findById(id).orElse(null);
    }

    public void addCoalizione(Coalizione coalizione) {
        coalizioneRepository.save(coalizione);
    }

    public void updateCoalizione(Coalizione coalizione) {
        coalizioneRepository.save(coalizione);
    }

    public void deleteCoalizione(Integer id) {
        coalizioneRepository.deleteById(id);
    }
}
