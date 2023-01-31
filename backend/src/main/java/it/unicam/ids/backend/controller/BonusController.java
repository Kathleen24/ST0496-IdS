package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Bonus;
import it.unicam.ids.backend.service.AziendaService;
import it.unicam.ids.backend.service.BonusService;
import it.unicam.ids.backend.util.EntityValidator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static it.unicam.ids.backend.entity.Bonus.Tipo.PUNTI;

@RestController
@RequestMapping("/bonus")
public class BonusController implements EntityValidator<Bonus> {

    private final BonusService bonusService;
    private final AziendaService aziendaService;

    public BonusController(BonusService bonusService, AziendaService aziendaService) {
        this.bonusService = bonusService;
        this.aziendaService = aziendaService;
    }

    public void validateEntity(Bonus bonus) {
        if (bonus==null)
            throw new NullPointerException("L'oggetto bonus è nullo");
        if(aziendaService.getAzienda(bonus.getAzienda().getId())==null)
            throw new IllegalArgumentException("L'azienda inserita non è esistente");
        if(bonus.getValore()<=0)
            throw new IllegalArgumentException("Il valore del buono non può essere minore uguale a 0");
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
    public void addBonus(
            @RequestParam Integer aziendaID,
            @RequestParam Integer valore,
            @RequestParam(defaultValue = "") String descrizione,
            @RequestParam Bonus.Tipo tipo
    ) {
        Bonus bonus = bonusService.addBonus(aziendaID, valore, descrizione, tipo);
    }

    public void updateBonus(Bonus bonus) {
        bonusService.updateBonus(bonus);
    }

    //Per sequence diagram Eliminazione bonus
    @DeleteMapping("/{id}")
    public void deleteBonus(@PathVariable Integer id) {
        //"Vuoi procedere all'eliminazione?" S/N
        bonusService.deleteBonus(id);
    }

    //Per sequence diagram Creazione bonus
    public void creaBonus(String nome, String descrizione){
        System.out.println(getAllBonusType());
        //utente sceglie tipo e valore
        //Bonus bonus = new Bonus(1, azienda, 10,"Primo bonus",PUNTI);
        //addBonus(bonus);
    }

    public String getAllBonusType() { //da controllare
        String s = PUNTI.toString() + "\n";
        s += Bonus.Tipo.CASHBACK.toString() + "\n";
        s += Bonus.Tipo.SCONTO.toString();
        return s;
    }
}