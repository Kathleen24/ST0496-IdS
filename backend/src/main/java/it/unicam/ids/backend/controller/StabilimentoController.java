package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Stabilimento;
import it.unicam.ids.backend.id.StabilimentoID;
import it.unicam.ids.backend.service.StabilimentoService;
import it.unicam.ids.backend.util.EntityValidator;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StabilimentoController implements EntityValidator<Stabilimento> {

    private final StabilimentoService stabilimentoService;


    public StabilimentoController(StabilimentoService stabilimentoService) {
        this.stabilimentoService = stabilimentoService;
    }


    @Override
    public void validateEntity(Stabilimento stabilimento) {
        if (stabilimento == null)
            throw new NullPointerException("L'oggetto stabilimento è nullo");
    }

    public List<Stabilimento> getAllStabilimenti() {
        return stabilimentoService.getAllStabilimenti();
    }

    public Stabilimento getStabilimento(StabilimentoID id) {
        return stabilimentoService.getStabilimento(id);
    }

    public void addStabilimento(Stabilimento stabilimento) {
        stabilimentoService.addStabilimento(stabilimento);
    }

    public void updateStabilimento(Stabilimento stabilimento) {
        stabilimentoService.updateStabilimento(stabilimento);
    }

    public void deleteStabilimento(StabilimentoID id) {
        stabilimentoService.deleteStabilimento(id);
    }
}
