package it.unicam.ids.backend;

//import it.unicam.ids.backend.Stabilimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StabilimentoRepository extends JpaRepository<Stabilimento,StabilimentoID>{
}
