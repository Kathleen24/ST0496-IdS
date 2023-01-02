package it.unicam.ids.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgrammaFedeltaService {
    @Autowired
    private ProgrammaFedeltaRepository programmaFedeltaRepository;

    public List<ProgrammaFedelta> getAllProgrammiFedelta() { return programmaFedeltaRepository.findAll();}

    public ProgrammaFedelta getProgrammaFedelta(ProgrammaFedeltaID programmaFedeltaID) {
        Optional<ProgrammaFedelta> programmaFedelta = this.programmaFedeltaRepository.findById(programmaFedeltaID);
        return programmaFedelta.orElse(null);
    }

    public void addProgrammaFedelta(ProgrammaFedelta programmaFedelta) {
        programmaFedeltaRepository.save(programmaFedelta);
    }

    public void updateProgrammaFedelta(ProgrammaFedeltaID programmaFedeltaID, ProgrammaFedelta programmaFedelta){
        programmaFedeltaRepository.save(programmaFedelta);
    }
    public void deleteProgrammaFedelta(ProgrammaFedeltaID programmaFedeltaID){ programmaFedeltaRepository.deleteById(programmaFedeltaID);}
}
