package tn.esprit.examen.nomPrenomClasseExamen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.examen.nomPrenomClasseExamen.entities.ElementPortfeuilleEntity;

@Repository
public interface ElementRepository extends JpaRepository<ElementPortfeuilleEntity, Long> {
}
