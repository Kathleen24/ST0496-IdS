package it.unicam.ids.backend.repository;

import it.unicam.ids.backend.entity.ProgrammaFedelta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgrammaFedeltaRepository extends JpaRepository<ProgrammaFedelta, Integer> {
}

