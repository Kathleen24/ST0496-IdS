package it.unicam.ids.backend.service;

import it.unicam.ids.backend.entity.Bonus;
import it.unicam.ids.backend.repository.AziendaRepository;
import it.unicam.ids.backend.repository.BonusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BonusService {

    private final BonusRepository bonusRepository;
    private final AziendaRepository aziendaRepository;


    public BonusService(
            BonusRepository bonusRepository,
            AziendaRepository aziendaRepository
    ) {
        this.bonusRepository = bonusRepository;
        this.aziendaRepository = aziendaRepository;
    }


    public List<Bonus> getAllBonus() {
        return bonusRepository.findAll();
    }

    public Bonus getBonus(Integer id) {
        return bonusRepository.findById(id).orElse(null);
    }

    public Bonus addBonus(Integer aziendaID, Integer valore, String descrizione, Bonus.Tipo tipo) {
        return bonusRepository.save(new Bonus(
                aziendaRepository.findById(aziendaID).orElseThrow(),
                valore, descrizione, tipo
        ));
    }

    public Bonus updateBonus(Bonus bonus) {
        return bonusRepository.save(bonus);
    }

    public void deleteBonus(Integer id) {
        bonusRepository.deleteById(id);
    }
}
