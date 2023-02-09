package it.unicam.ids.backend.repository;

import it.unicam.ids.backend.entity.Coalizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoalizioneRepository extends JpaRepository<Coalizione, Integer> {
}
