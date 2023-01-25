package it.unicam.ids.backend.service;

import it.unicam.ids.backend.entity.ProgrammaFedelta;
import it.unicam.ids.backend.id.LivelloID;
import it.unicam.ids.backend.repository.LivelloRepository;
import it.unicam.ids.backend.repository.ProgrammaFedeltaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgrammaFedeltaService {

    private final ProgrammaFedeltaRepository programmaFedeltaRepository;
    private final LivelloRepository livelloRepository;


    public ProgrammaFedeltaService(
            ProgrammaFedeltaRepository programmaFedeltaRepository,
            LivelloRepository livelloRepository
    ) {
        this.programmaFedeltaRepository = programmaFedeltaRepository;
        this.livelloRepository = livelloRepository;
    }


    public List<ProgrammaFedelta> getAllProgrammiFedelta() {
        return programmaFedeltaRepository.findAll();
    }

    public ProgrammaFedelta getProgrammaFedelta(Integer pfID) {
        return programmaFedeltaRepository.findById(pfID).orElse(null);
    }

    public void addProgrammaFedelta(Integer pfID, List<LivelloID> livelli) {
        ProgrammaFedelta pf = new ProgrammaFedelta(
                pfID,
                livelli.stream().map(livelloRepository::findById)
                        .map(Optional::orElseThrow)
                        .toList()
        );
        addProgrammaFedelta(pf);
    }

    public void addProgrammaFedelta(ProgrammaFedelta pf) {
        programmaFedeltaRepository.save(pf);
    }

    public void updateProgrammaFedelta(ProgrammaFedelta pf) {
        programmaFedeltaRepository.save(pf);
    }

    public void deleteProgrammaFedelta(Integer pfID) {
        programmaFedeltaRepository.deleteById(pfID);
    }
}
