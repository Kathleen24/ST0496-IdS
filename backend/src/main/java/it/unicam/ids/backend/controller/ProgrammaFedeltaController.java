package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.ProgrammaFedelta;
import it.unicam.ids.backend.service.ProgrammaFedeltaService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ProgrammaFedelta getProgrammaFedelta(@PathVariable Integer id) {
        return programmaFedeltaService.getProgrammaFedelta(id);
    }

    @PostMapping("/add")
    public void addProgrammaFedelta(
            @RequestParam Integer aziendaID,
            @RequestParam List<Integer> bonus,
            @RequestParam List<Integer> soglie
    ) {
        programmaFedeltaService.addProgrammaFedelta(aziendaID, bonus, soglie);
    }

    public void updateProgrammaFedelta(ProgrammaFedelta pf) {
        programmaFedeltaService.updateProgrammaFedelta(pf);
    }

    //Per sequence diagram Elimina Programma Fedeltà, leggermente diverso dal sequence diagram
    @DeleteMapping("/{id}")
    public void deleteProgrammaFedelta(@PathVariable Integer id) {
        //"Vuoi procedere all'eliminazione?" S/N
        programmaFedeltaService.deleteProgrammaFedelta(id);
    }
}
