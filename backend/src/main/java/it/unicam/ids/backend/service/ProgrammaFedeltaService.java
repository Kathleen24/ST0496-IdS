package it.unicam.ids.backend.service;

import it.unicam.ids.backend.entity.ProgrammaFedelta;
import it.unicam.ids.backend.repository.AziendaRepository;
import it.unicam.ids.backend.repository.BonusRepository;
import it.unicam.ids.backend.repository.ProgrammaFedeltaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgrammaFedeltaService {

    private final ProgrammaFedeltaRepository programmaFedeltaRepository;
    private final AziendaRepository aziendaRepository;
    private final BonusRepository bonusRepository;


    public ProgrammaFedeltaService(
            ProgrammaFedeltaRepository programmaFedeltaRepository,
            AziendaRepository aziendaRepository,
            BonusRepository bonusRepository
    ) {
        this.programmaFedeltaRepository = programmaFedeltaRepository;
        this.aziendaRepository = aziendaRepository;
        this.bonusRepository = bonusRepository;
    }




    public List<ProgrammaFedelta> getAllProgrammiFedelta() {
        return programmaFedeltaRepository.findAll();
    }

    public ProgrammaFedelta getProgrammaFedelta(Integer id) {
        return programmaFedeltaRepository.findById(id).orElse(null);
    }

    public ProgrammaFedelta addProgrammaFedelta(Integer aziendaID, List<Integer> bonus, List<Integer> soglie, Boolean attivo) {
        return programmaFedeltaRepository.save(new ProgrammaFedelta(
                aziendaRepository.findById(aziendaID).orElseThrow(),
                bonus.stream().map(bonusRepository::findById)
                        .map(Optional::orElseThrow)
                        .toList(),
                soglie, attivo
        ));
    }

    public void updateProgrammaFedelta(ProgrammaFedelta pf) {
        programmaFedeltaRepository.save(pf);
    }

    public void deleteProgrammaFedelta(Integer id) {
        programmaFedeltaRepository.deleteById(id);
    }
}
