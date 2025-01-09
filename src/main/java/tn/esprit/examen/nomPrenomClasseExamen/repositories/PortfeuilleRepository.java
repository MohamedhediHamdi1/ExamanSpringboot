package tn.esprit.examen.nomPrenomClasseExamen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.examen.nomPrenomClasseExamen.entities.PortfeuilleEntity;

@Repository
public interface PortfeuilleRepository extends JpaRepository<PortfeuilleEntity,Long> {

    PortfeuilleEntity findByReference(int reference);
}
