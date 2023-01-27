package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.AmministratorePiattaforma;
import it.unicam.ids.backend.service.AmministratorePiattaformaService;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
@RequestMapping("/amministratorePiattaforma")
public class AmministratorePiattaformaController {
    private final AmministratorePiattaformaService amministratorePiattaformaService;


    public AmministratorePiattaformaController(AmministratorePiattaformaService amministratorePiattaformaService) {
        this.amministratorePiattaformaService = amministratorePiattaformaService;
    }

    @GetMapping("/{username}")
    public AmministratorePiattaforma getAmministratorePiattaforma(String username) {
        return amministratorePiattaformaService.getAmministratorePiattaforma(Objects.hash(username));
    }

    public void updateAmministratorePiattaforma(String username, String password) {
        amministratorePiattaformaService.updateAmministratorePiattaforma(username,password);
    }

}
