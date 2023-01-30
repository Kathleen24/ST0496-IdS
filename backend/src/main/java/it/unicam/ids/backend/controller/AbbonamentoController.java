package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Abbonamento;
import it.unicam.ids.backend.entity.PianoTariffario;
import it.unicam.ids.backend.service.AbbonamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abbonamento")
public class AbbonamentoController {

    private final AbbonamentoService abbonamentoService;


    public AbbonamentoController(AbbonamentoService abbonamentoService) {
        this.abbonamentoService = abbonamentoService;
    }


    @GetMapping("/all")
    public List<Abbonamento> getAllAbbonamenti() {
        return abbonamentoService.getAllAbbonamenti();
    }

    @GetMapping("/all")
    public List<Abbonamento> getAllAbbonamenti(@RequestParam Boolean attivo) {
        return abbonamentoService.getAllAbbonamenti(attivo);
    }

    @GetMapping("/{id}")
    public Abbonamento getAbbonamento(@PathVariable Integer id) {
        return abbonamentoService.getAbbonamento(id);
    }

    @PostMapping("/add")
    public Abbonamento addAbbonamento(@RequestBody Abbonamento abbonamento) {
        return abbonamentoService.addAbbonamento(abbonamento);
    }

    @PostMapping("/add")
    public Abbonamento addAbbonamento(
            @RequestParam PianoTariffario pianoTariffario,
            @RequestParam String descrizione,
            @RequestParam Boolean attivo
    ) {
        return abbonamentoService.addAbbonamento(pianoTariffario, descrizione, attivo);
    }

    @PostMapping("/update")
    public void updateAbbonamento(@RequestBody Abbonamento abbonamento) {
        abbonamentoService.updateAbbonamento(abbonamento);
    }

    @PostMapping("/update")
    public void updateAbbonamento(
            @RequestParam PianoTariffario pianoTariffario,
            @RequestParam(defaultValue = "") String descrizione,
            @RequestParam Boolean attivo
    ) {
        abbonamentoService.updateAbbonamento(pianoTariffario, descrizione, attivo);
    }

    @DeleteMapping("/{id}")
    public void deleteAbbonamento(@PathVariable Integer id) {
        abbonamentoService.deleteAbbonamento(id);
    }
}
