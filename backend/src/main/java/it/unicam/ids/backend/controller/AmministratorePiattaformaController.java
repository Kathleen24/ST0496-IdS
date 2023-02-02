package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.AmministratorePiattaforma;
import it.unicam.ids.backend.service.AmministratorePiattaformaService;
import it.unicam.ids.backend.util.EntityValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/amministratorePiattaforma")
public class AmministratorePiattaformaController implements EntityValidator<AmministratorePiattaforma> {

    private final AmministratorePiattaformaService amministratorePiattaformaService;


    public AmministratorePiattaformaController(AmministratorePiattaformaService amministratorePiattaformaService) {
        this.amministratorePiattaformaService = amministratorePiattaformaService;
    }


    @Override
    public void validateEntity(AmministratorePiattaforma amministratorePiattaforma) {
        //password Integer
        if (amministratorePiattaforma == null)
            throw new NullPointerException("L'oggetto amministratore piattaforma è nullo");
    }

    @GetMapping("/{username}")
    public AmministratorePiattaforma getAmministratorePiattaforma(@PathVariable String username) {
        return amministratorePiattaformaService.getAmministratorePiattaforma(Objects.hash(username));
    }

    public void updateAmministratorePiattaforma(String username, String password) {
        amministratorePiattaformaService.updateAmministratorePiattaforma(username, password);
    }
}
