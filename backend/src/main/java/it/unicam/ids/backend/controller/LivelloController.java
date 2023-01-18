package it.unicam.ids.backend.controller;


import it.unicam.ids.backend.entity.Bonus;
import it.unicam.ids.backend.entity.Dipendente;
import it.unicam.ids.backend.entity.Livello;
import it.unicam.ids.backend.id.LivelloID;
import it.unicam.ids.backend.service.LivelloService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static it.unicam.ids.backend.entity.Bonus.Tipo.PUNTI;


@RestController
public class LivelloController {
    private final LivelloService livelloService;

    public LivelloController(LivelloService livelloService) {
        this.livelloService = livelloService;
    }

    public List<Livello> getAllLivello() {
        return livelloService.getAllLivello();
    }

    public Livello getLivello(LivelloID id) {
        return livelloService.getLivello(id);
    }

    public void addLivello(Livello livello) {
        livelloService.addLivello(livello);
    }

    public void updateLivello(Livello livello) {
        bonusService.updateLivello(bonus);
    }

    public void deleteLivello(LivelloID id) {
        livelloService.deleteLivello(id);
    }

    //Per sequence diagram Creazione livello
    public void creaLivello(String identificativoLivello, String descrizione){
        System.out.println(getAllBonus());
        //utente sceglie tipo e valore
        Bonus bonus=new Bonus(1,10,"Primo bonus",PUNTI);
        addBonus(bonus);
    }


    //Per sequence diagram Elimina Livello
    public void eliminaLivello(LivelloID id){
        System.out.println("Sei sicuro di voler eliminare il livello? S/N");
        if(true)
            deleteLivello(id);
    }
}
