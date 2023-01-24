package it.unicam.ids.backend.repository;

import it.unicam.ids.backend.entity.Coalizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CoalizioneRepository extends JpaRepository<Coalizione,Integer> {

}
