package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.ProgrammaFedelta;
import it.unicam.ids.backend.id.LivelloID;
import it.unicam.ids.backend.id.ProgrammaFedeltaID;
import it.unicam.ids.backend.service.ProgrammaFedeltaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static it.unicam.ids.backend.entity.Bonus.Tipo.PUNTI;

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

    public ProgrammaFedelta getProgrammaFedelta(ProgrammaFedeltaID pfID) {
        return programmaFedeltaService.getProgrammaFedelta(pfID);
    }

    @PostMapping("/add")
    public void addProgrammaFedelta(@RequestBody ObjectNode node) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ProgrammaFedeltaID pfID = mapper.treeToValue(node.get("pfID"), ProgrammaFedeltaID.class);

        List<LivelloID> livelli = new ArrayList<>();
        for (JsonNode arrNode : node.get("livelli")) {
            livelli.add(mapper.treeToValue(arrNode, LivelloID.class));
        }

        programmaFedeltaService.addProgrammaFedelta(pfID, livelli);
    }

    public void addProgrammaFedelta(ProgrammaFedelta pf) {
        programmaFedeltaService.addProgrammaFedelta(pf);
    }

    public void updateProgrammaFedelta(ProgrammaFedelta pf) {
        programmaFedeltaService.updateProgrammaFedelta(pf);
    }

    public void deleteProgrammaFedelta(ProgrammaFedeltaID pfID) {
        programmaFedeltaService.deleteProgrammaFedelta(pfID);
    }

    //Per sequence diagram Elimina Programma Fedeltà, leggermente diverso dal sequence diagram
    public void eliminaProgrammaFedelta(ProgrammaFedeltaID id){
        System.out.println("Sei sicuro di voler eliminare il livello? S/N");
        if(true)
            deleteProgrammaFedelta(id);
    }

}
