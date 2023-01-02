package it.unicam.ids.backend;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StabilimentoService {
    @Autowired
    private StabilimentoRepository stabilimentoRepository;

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

    public void updateStabilimento(StabilimentoID id, Stabilimento stabilimento) {
        stabilimentoRepository.save(stabilimento);
    }

    public void deleteStabilimento(StabilimentoID id) {
        stabilimentoRepository.deleteById(id);
    }
}

