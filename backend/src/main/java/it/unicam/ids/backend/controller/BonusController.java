package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Bonus;
import it.unicam.ids.backend.service.BonusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static it.unicam.ids.backend.entity.Bonus.Tipo.PUNTI;

@RestController
@RequestMapping("/bonus")
public class BonusController {

    private final BonusService bonusService;


    public BonusController(BonusService bonusService) {
        this.bonusService = bonusService;
    }


    @GetMapping("/all")
    public List<Bonus> getAllBonus() {
        return bonusService.getAllBonus();
    }

    @GetMapping("/{id}")
    public Bonus getBonus(@PathVariable Integer id) {
        return bonusService.getBonus(id);
    }

    @PostMapping("/add")
    public Bonus addBonus(
            @RequestParam Integer aziendaID,
            @RequestParam Integer valore,
            @RequestParam(defaultValue = "") String descrizione,
            @RequestParam Bonus.Tipo tipo
    ) {
        return bonusService.addBonus(aziendaID, valore, descrizione, tipo);
    }

    @PostMapping("/update")
    public Bonus updateBonus(@RequestBody Bonus bonus) {
        return bonusService.updateBonus(bonus);
    }

    @DeleteMapping("/{id}")
    public void deleteBonus(@PathVariable Integer id) {
        //"Vuoi procedere all'eliminazione?" S/N
        bonusService.deleteBonus(id);
    }

    public String getAllBonusType() { //da controllare
        String s = PUNTI.toString() + "\n";
        s += Bonus.Tipo.CASHBACK.toString() + "\n";
        s += Bonus.Tipo.SCONTO.toString();
        return s;
    }
}