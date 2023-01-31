package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Abbonamento;
import it.unicam.ids.backend.entity.PianoTariffario;
import it.unicam.ids.backend.service.AbbonamentoService;
import it.unicam.ids.backend.service.PianoTariffarioService;
import it.unicam.ids.backend.util.EntityValidator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abbonamento")
public class AbbonamentoController implements EntityValidator<Abbonamento> {

    private final AbbonamentoService abbonamentoService;
    private final PianoTariffarioService pianoTariffarioService;

    public AbbonamentoController(AbbonamentoService abbonamentoService, PianoTariffarioService pianoTariffarioService) {
        this.abbonamentoService = abbonamentoService;
        this.pianoTariffarioService = pianoTariffarioService;
    }


    @Override
    public void validateEntity(Abbonamento abbonamento) {
        if (abbonamento==null)
            throw new NullPointerException("L'oggetto abbonamento è nullo");
        if(pianoTariffarioService.getPianoTariffario(abbonamento.getPianoTariffario().getId())==null)
            throw new IllegalArgumentException("Il piano tariffario inserito non è esistente");
        if(abbonamento.getDataUltimoPagamento().before(abbonamento.getDataIscrizione()))
            throw new IllegalArgumentException("Il pagamento non può avvenire prima dell'iscrizione");
    }

    @GetMapping("/all")
    public List<Abbonamento> getAllAbbonamenti(){
        return abbonamentoService.getAllAbbonamenti();
    }

    @GetMapping("/all")
    public List<Abbonamento> getAllAbbonamenti(@RequestParam Boolean attivo){
        return abbonamentoService.getAllAbbonamenti(attivo);
    }

    @GetMapping("/{id}")
    public Abbonamento getAbbonamento(@PathVariable Integer id){
        return abbonamentoService.getAbbonamento(id);
    }

    @PostMapping("/add")
    public Abbonamento addAbbonamento(@RequestBody Abbonamento abbonamento){
        return abbonamentoService.addAbbonamento(abbonamento);
    }

    @PostMapping("/add")
    public Abbonamento addAbbonamento(@RequestParam PianoTariffario pianoTariffario,
                                      @RequestParam String descrizione,
                                      @RequestParam Boolean attivo){
        return abbonamentoService.addAbbonamento(pianoTariffario, descrizione, attivo);
    }

    @PostMapping("/update")
    public void updateAbbonamento(@RequestBody Abbonamento abbonamento){
        abbonamentoService.addAbbonamento(abbonamento);
    }

    @PostMapping("/update")
    public void updateAbbonamento(@RequestParam PianoTariffario pianoTariffario,
                                  @RequestParam(defaultValue = "") String descrizione,
                                  @RequestParam Boolean attivo){
        abbonamentoService.addAbbonamento(pianoTariffario, descrizione, attivo);
    }

    @DeleteMapping("/{id}")
    public void deleteAbbonamento(@PathVariable Integer id){
        abbonamentoService.deleteAbbonamento(id);
    }
}
