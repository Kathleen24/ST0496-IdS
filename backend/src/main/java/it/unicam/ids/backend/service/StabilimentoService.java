package it.unicam.ids.backend.service;

import it.unicam.ids.backend.entity.Stabilimento;
import it.unicam.ids.backend.id.StabilimentoID;
import it.unicam.ids.backend.repository.StabilimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StabilimentoService {

    private final StabilimentoRepository stabilimentoRepository;


    public StabilimentoService(StabilimentoRepository stabilimentoRepository) {
        this.stabilimentoRepository = stabilimentoRepository;
    }


    public List<Stabilimento> getAllStabilimenti() {
        return stabilimentoRepository.findAll();
    }

    public Stabilimento getStabilimento(StabilimentoID id) {
        Optional<Stabilimento> stabilimento = this.stabilimentoRepository.findById(id);
        return stabilimento.orElse(null);
    }

    public void addStabilimento(Stabilimento stabilimento) {
        stabilimentoRepository.save(stabilimento);
    }

    public void updateStabilimento(Stabilimento stabilimento) {
        stabilimentoRepository.save(stabilimento);
    }

    public void deleteStabilimento(StabilimentoID id) {
        stabilimentoRepository.deleteById(id);
    }
}

