package it.unicam.ids.backend.service;

import it.unicam.ids.backend.entity.Abbonamento;
import it.unicam.ids.backend.repository.AbbonamentoRepository;
import it.unicam.ids.backend.repository.PianoTariffarioRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AbbonamentoService {

    private final AbbonamentoRepository abbonamentoRepository;
    private final PianoTariffarioRepository pianoTariffarioRepository;


    public AbbonamentoService(
            AbbonamentoRepository abbonamentoRepository,
            PianoTariffarioRepository pianoTariffarioRepository
    ) {
        this.abbonamentoRepository = abbonamentoRepository;
        this.pianoTariffarioRepository = pianoTariffarioRepository;
    }


    public List<Abbonamento> getAllAbbonamenti() {
        return abbonamentoRepository.findAll();
    }

    public List<Abbonamento> getAllAbbonamenti(Boolean attivo) {
        return abbonamentoRepository.getAllAbbonamentiAttivi(attivo);
    }

    public Abbonamento getAbbonamento(Integer id) {
        return abbonamentoRepository.findById(id).orElseThrow();
    }

    public Abbonamento addAbbonamento(Integer pianoTariffarioId, String descrizione, Boolean attivo) {
        return abbonamentoRepository.save(new Abbonamento(
                pianoTariffarioRepository.findById(pianoTariffarioId).orElseThrow(),
                descrizione, attivo
        ));
    }

    public void updateAbbonamento(Abbonamento abbonamento) {
        abbonamentoRepository.save(abbonamento);
    }

    public void deleteAbbonamento(Integer id) {
        abbonamentoRepository.deleteById(id);
    }


    @Scheduled(cron = "@daily")
    private void checkAbbonamenti() {
        abbonamentoRepository.findAll().stream()
                .filter(abbonamento -> abbonamento.getDataUltimoPagamento().isBefore(LocalDate.now()))
                .forEach(abbonamento -> {
                    abbonamento.setDataUltimoPagamento(LocalDate.now());
                    updateAbbonamento(abbonamento);
                });
    }
}