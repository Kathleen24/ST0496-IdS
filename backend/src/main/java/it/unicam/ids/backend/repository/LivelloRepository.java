package it.unicam.ids.backend.repository;

import it.unicam.ids.backend.entity.Livello;
import it.unicam.ids.backend.id.LivelloID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivelloRepository extends JpaRepository<Livello, LivelloID> {
}
