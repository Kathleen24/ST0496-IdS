package it.unicam.ids.backend;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProgrammaFedeltaController {

    private final ProgrammaFedeltaService programmaFedeltaService;


    public ProgrammaFedeltaController(ProgrammaFedeltaService programmaFedeltaService) {
        this.programmaFedeltaService = programmaFedeltaService;
    }


    public List<ProgrammaFedelta> getAllProgrammiFedelta() {
        return programmaFedeltaService.getAllProgrammiFedelta();
    }

    public ProgrammaFedelta getProgrammaFedelta(ProgrammaFedeltaID programmaFedeltaID) {
        return programmaFedeltaService.getProgrammaFedelta(programmaFedeltaID);
    }

    public void addProgrammaFedelta(ProgrammaFedelta programmaFedelta) {
        programmaFedeltaService.addProgrammaFedelta(programmaFedelta);
    }

    public void updateProgrammaFedelta(ProgrammaFedelta programmaFedelta) {
        programmaFedeltaService.updateProgrammaFedelta(programmaFedelta);
    }

    public void deleteProgrammaFedelta(ProgrammaFedeltaID programmaFedeltaID) {
        programmaFedeltaService.deleteProgrammaFedelta(programmaFedeltaID);
    }
}
