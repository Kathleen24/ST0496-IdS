package it.unicam.ids.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StabilimentoController {
    @Autowired
    private StabilimentoService stabilimentoServiceDB;

    public List<Stabilimento> getAllStabilimenti() {
        return stabilimentoServiceDB.getAllStabilimenti();
    }

    public Stabilimento getStabilimento(StabilimentoID id) {
        return stabilimentoServiceDB.getStabilimento(id);
    }

    public void addStabilimento(Stabilimento stabilimento) {
        stabilimentoServiceDB.addStabilimento(stabilimento);
    }

    public void updateStabilimento(StabilimentoID id, Stabilimento stabilimento) {
        stabilimentoServiceDB.updateStabilimento(id,stabilimento); //in teoria senza id tra parentesi
    }

    public void deleteStabilimento(StabilimentoID id) {
        stabilimentoServiceDB.deleteStabilimento(id);
    }
}
