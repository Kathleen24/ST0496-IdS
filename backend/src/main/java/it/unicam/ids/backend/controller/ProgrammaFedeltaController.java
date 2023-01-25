package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.ProgrammaFedelta;
import it.unicam.ids.backend.service.ProgrammaFedeltaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/programmiFedelta")
public class ProgrammaFedeltaController {

    private final ProgrammaFedeltaService programmaFedeltaService;


    public ProgrammaFedeltaController(ProgrammaFedeltaService programmaFedeltaService) {
        this.programmaFedeltaService = programmaFedeltaService;
    }


    @GetMapping("/all")
    public List<ProgrammaFedelta> getAllProgrammiFedelta() {
        return programmaFedeltaService.getAllProgrammiFedelta();
    }

    public ProgrammaFedelta getProgrammaFedelta(Integer pfID) {
        return programmaFedeltaService.getProgrammaFedelta(pfID);
    }

    @PostMapping("/add")
    public void addProgrammaFedelta(
            @RequestParam Integer aziendaID,
            @RequestParam List<Integer> bonus,
            @RequestParam List<Integer> soglie
    ) {
        programmaFedeltaService.addProgrammaFedelta(aziendaID, bonus, soglie);
    }

    public void addProgrammaFedelta(ProgrammaFedelta pf) {
        programmaFedeltaService.addProgrammaFedelta(pf);
    }

    public void updateProgrammaFedelta(ProgrammaFedelta pf) {
        programmaFedeltaService.updateProgrammaFedelta(pf);
    }

    //Per sequence diagram Elimina Programma Fedeltà, leggermente diverso dal sequence diagram
    public void deleteProgrammaFedelta(Integer pfID) {
        //"Vuoi procedere all'eliminazione?" S/N
        programmaFedeltaService.deleteProgrammaFedelta(pfID);
    }
}
