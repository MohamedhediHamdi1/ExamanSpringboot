package tn.esprit.examen.nomPrenomClasseExamen.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.examen.nomPrenomClasseExamen.entities.ActionEntity;

import java.util.Date;
import java.util.List;

@Repository
public interface ActionRepository extends JpaRepository<ActionEntity, Long> {

    ActionEntity findBySymbol(String symbol);

    @Query("select a from ActionEntity a join a.orders orders  where orders.portfeuille.reference = :reference and a.dateEmission between :startDate and :endDate")
    List<String> findSymbols(@Param("reference")  int reference, @Param("startDate")Date startDate, @Param("endDate")Date endDate);
}
