package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.ProgrammaFedelta;
import it.unicam.ids.backend.service.AziendaService;
import it.unicam.ids.backend.service.ProgrammaFedeltaService;
import it.unicam.ids.backend.util.EntityValidator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programmiFedelta")
public class ProgrammaFedeltaController implements EntityValidator<ProgrammaFedelta> {

    private final ProgrammaFedeltaService programmaFedeltaService;
    private AziendaService aziendaService;


    public ProgrammaFedeltaController(ProgrammaFedeltaService programmaFedeltaService, AziendaService aziendaService) {
        this.programmaFedeltaService = programmaFedeltaService;
        this.aziendaService = aziendaService;
    }

    public void validateEntity(ProgrammaFedelta programmaFedelta) {
        if (programmaFedelta==null)
            throw new NullPointerException("L'oggetto programma fedeltà è nullo");
        if(aziendaService.getAzienda(programmaFedelta.getAzienda().getId())==null)
            throw new IllegalArgumentException("L'azienda inserita non è esistente");
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
