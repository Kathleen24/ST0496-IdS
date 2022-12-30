package it.unicam.ids.backend;

//import it.unicam.ids.backend.Azienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AziendaRepository extends JpaRepository<Azienda,Integer> {
}
