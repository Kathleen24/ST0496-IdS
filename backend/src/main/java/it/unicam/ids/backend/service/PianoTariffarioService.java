package it.unicam.ids.backend.service;

import it.unicam.ids.backend.entity.PianoTariffario;
import it.unicam.ids.backend.repository.PianoTariffarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PianoTariffarioService {

    private final PianoTariffarioRepository pianoTariffarioRepository;


    public PianoTariffarioService(PianoTariffarioRepository pianoTariffarioRepository) {
        this.pianoTariffarioRepository = pianoTariffarioRepository;
    }


    public List<PianoTariffario> getAllPianiTariffari() {
        return pianoTariffarioRepository.findAll();
    }

    public PianoTariffario getPianoTariffario(Integer id) {
        return pianoTariffarioRepository.findById(id).orElse(null);
    }

    public PianoTariffario addPianoTariffario(
            Double costo, Boolean newsLetterService, Boolean emailService, Boolean calendarService, Boolean smsService
    ) {
        return pianoTariffarioRepository.save(
                new PianoTariffario(costo, newsLetterService, emailService, calendarService, smsService)
        );
    }

    public void updatePianoTariffario(PianoTariffario pianoTariffario) {
        pianoTariffarioRepository.save(pianoTariffario);
    }

    public void deletePianoTariffario(Integer id) {
        pianoTariffarioRepository.deleteById(id);
    }
}