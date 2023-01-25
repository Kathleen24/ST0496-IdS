package it.unicam.ids.backend.service;

import it.unicam.ids.backend.entity.Bonus;
import it.unicam.ids.backend.repository.BonusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BonusService {
    private final BonusRepository bonusRepository;


    public BonusService(BonusRepository bonusRepository) {
        this.bonusRepository = bonusRepository;
    }


    public List<Bonus> getAllBonus() {
        return bonusRepository.findAll();
    }

    public Bonus getBonus(Integer id) {
        return bonusRepository.findById(id).orElse(null);
    }

    public void addBonus(Bonus bonus) {
        bonusRepository.save(bonus);
    }

    public void updateBonus(Bonus bonus) {
        bonusRepository.save(bonus);
    }

    public void deleteBonus(Integer id) {
        bonusRepository.deleteById(id);
    }
}
