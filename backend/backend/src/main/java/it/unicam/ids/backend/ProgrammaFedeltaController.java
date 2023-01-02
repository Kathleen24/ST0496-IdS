package it.unicam.ids.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProgrammaFedeltaController {
    @Autowired
    private ProgrammaFedeltaService programmaFedeltaService;

    public List<ProgrammaFedelta> getAllProgrammiFedelta() {
        return programmaFedeltaService.getAllProgrammiFedelta();
    }

    public ProgrammaFedelta getProgrammaFedelta(ProgrammaFedeltaID programmaFedeltaID) {
        return programmaFedeltaService.getProgrammaFedelta(programmaFedeltaID);
    }

    public void addProgrammaFedelta(ProgrammaFedelta programmaFedelta) {
        programmaFedeltaService.addProgrammaFedelta(programmaFedelta);
    }

    public void updateProgrammaFedelta(ProgrammaFedeltaID programmaFedeltaID, ProgrammaFedelta programmaFedelta) {
        programmaFedeltaService.updateProgrammaFedelta(programmaFedeltaID, programmaFedelta);
    }

    public void deleteProgrammaFedelta(ProgrammaFedeltaID programmaFedeltaID) {
        programmaFedeltaService.deleteProgrammaFedelta(programmaFedeltaID);
    }
}
