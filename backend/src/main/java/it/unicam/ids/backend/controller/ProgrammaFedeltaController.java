package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Bonus;
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
    private final AziendaService aziendaService;


    public ProgrammaFedeltaController(
            ProgrammaFedeltaService programmaFedeltaService,
            AziendaService aziendaService
    ) {
        this.programmaFedeltaService = programmaFedeltaService;
        this.aziendaService = aziendaService;
    }


    @Override
    public void validateEntity(ProgrammaFedelta programmaFedelta) {
        if (programmaFedelta == null)
            throw new NullPointerException("L'oggetto programma fedeltà è nullo");

        if (aziendaService.getAzienda(programmaFedelta.getAzienda().getId()) == null)
            throw new IllegalArgumentException("L'azienda inserita non è esistente");
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
    public ProgrammaFedelta addProgrammaFedelta(
            @RequestParam Integer aziendaID,
            @RequestParam List<Integer> bonus,
            @RequestParam List<Integer> soglie
    ) {
        return programmaFedeltaService.addProgrammaFedelta(aziendaID, bonus, soglie);
    }

    public void updateProgrammaFedelta(ProgrammaFedelta pf) {
        programmaFedeltaService.updateProgrammaFedelta(pf);
    }

    @DeleteMapping("/{id}")
    public void deleteProgrammaFedelta(@PathVariable Integer id) {
        programmaFedeltaService.deleteProgrammaFedelta(id);
    }

    public List<Bonus> getAllBonusOf(Integer pfID) {
        return getProgrammaFedelta(pfID).getBonus();
    }

    public List<ProgrammaFedelta> getAllProgrammiFedeltaOf(Integer aziendaID) {
        return programmaFedeltaService.getAllProgrammiFedeltaOf(aziendaID);
    }
}
