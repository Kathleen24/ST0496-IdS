package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Bonus;
import it.unicam.ids.backend.service.BonusService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static it.unicam.ids.backend.entity.Bonus.Tipo.PUNTI;

@RestController
public class BonusController {
    private final BonusService bonusService;

    public BonusController(BonusService bonusService) {
        this.bonusService = bonusService;
    }

    public List<Bonus> getAllBonus() {
        return bonusService.getAllBonus();
    }

    public Bonus getBonus(Integer id) {
        return bonusService.getBonus(id);
    }

    public void addBonus(Bonus bonus) {
        bonusService.addBonus(bonus);
    }

    public void updateBonus(Bonus bonus) {
        bonusService.updateBonus(bonus);
    }

    public void deleteBonus(Integer id) {
        bonusService.deleteBonus(id);
    }

    //Per sequence diagram Creazione livello
    public void creaBonus(String nome, String descrizione){
        System.out.println(getAllBonusType());
        //utente sceglie tipo e valore
        Bonus bonus=new Bonus(1,10,"Primo bonus",PUNTI);
        addBonus(bonus);
    }

    public String getAllBonusType() { //da controllare
        String s = PUNTI.toString() + "\n";
        s += Bonus.Tipo.CASHBACK.toString() + "\n";
        s += Bonus.Tipo.SCONTO.toString();
        return s;
    }


}
