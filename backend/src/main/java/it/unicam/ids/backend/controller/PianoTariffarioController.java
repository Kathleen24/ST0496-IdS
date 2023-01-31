package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.PianoTariffario;
import it.unicam.ids.backend.service.PianoTariffarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pianoTariffario")
public class PianoTariffarioController {

    private final PianoTariffarioService pianoTariffarioService;


    public PianoTariffarioController(PianoTariffarioService pianoTariffarioService) {
        this.pianoTariffarioService = pianoTariffarioService;
    }


    @GetMapping("/all")
    public List<PianoTariffario> getAllPianiTariffari() {
        return pianoTariffarioService.getAllPianiTariffari();
    }

    @GetMapping("/{id}")
    public PianoTariffario getPianoTariffario(@PathVariable Integer id) {
        return pianoTariffarioService.getPianoTariffario(id);
    }

    @PostMapping("/add")
    public PianoTariffario addPianoTariffario(
            @RequestParam Double costo,
            @RequestParam Boolean newLetterService,
            @RequestParam Boolean emailService,
            @RequestParam Boolean calendarService,
            @RequestParam Boolean smsService
    ) {
        return pianoTariffarioService.addPianoTariffario(costo, newLetterService, emailService, calendarService, smsService);
    }

    @PostMapping("/update")
    public void updatePianoTariffario(@RequestBody PianoTariffario pianoTariffario) {
        pianoTariffarioService.updatePianoTariffario(pianoTariffario);
    }

    @DeleteMapping("/{id}")
    public void deletePianoTariffario(@PathVariable Integer id) {
        pianoTariffarioService.deletePianoTariffario(id);
    }
}