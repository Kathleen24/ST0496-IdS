package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Bonus;
import it.unicam.ids.backend.entity.ProgrammaFedelta;
import it.unicam.ids.backend.id.LivelloID;
import it.unicam.ids.backend.id.ProgrammaFedeltaID;
import it.unicam.ids.backend.service.ProgrammaFedeltaService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static it.unicam.ids.backend.entity.Bonus.Tipo.PUNTI;

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

    //Per sequence diagram Elimina Programma Fedeltà, leggermente diverso dal sequence diagram
    public void eliminaProgrammaFedelta(ProgrammaFedeltaID id){
        System.out.println("Sei sicuro di voler eliminare il livello? S/N");
        if(true)
            deleteProgrammaFedelta(id);
    }

}
