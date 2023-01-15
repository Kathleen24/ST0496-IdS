package it.unicam.ids.backend.repository;

import it.unicam.ids.backend.entity.ProgrammaFedeltaDelCliente;
import it.unicam.ids.backend.id.ProgrammaFedeltaDelClienteID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammaFedeltaDelClienteRepository
        extends JpaRepository<ProgrammaFedeltaDelCliente, ProgrammaFedeltaDelClienteID> {
}
