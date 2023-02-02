package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Bonus;
import it.unicam.ids.backend.service.AziendaService;
import it.unicam.ids.backend.service.BonusService;
import it.unicam.ids.backend.util.EntityValidator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bonus")
public class BonusController implements EntityValidator<Bonus> {

    private final BonusService bonusService;
    private final AziendaService aziendaService;


    public BonusController(BonusService bonusService, AziendaService aziendaService) {
        this.bonusService = bonusService;
        this.aziendaService = aziendaService;
    }


    @Override
    public void validateEntity(Bonus bonus) {
        if (bonus == null)
            throw new NullPointerException("L'oggetto bonus è nullo");
        if(bonus.getValore() <= 0)
            throw new IllegalArgumentException("Il valore del buono non può essere minore uguale a 0");

        if(aziendaService.getAzienda(bonus.getAzienda().getId()) == null)
            throw new IllegalArgumentException("L'azienda inserita non è esistente");
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
}