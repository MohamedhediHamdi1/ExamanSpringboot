package tn.esprit.examen.nomPrenomClasseExamen.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examen.nomPrenomClasseExamen.entities.OrdreEntity;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Statut;
import tn.esprit.examen.nomPrenomClasseExamen.entities.TypeOrdre;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.OrdreRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ExamanService {

    OrdreRepository ordreRepository;

    @Scheduled(fixedDelay = 120000)
    void checkORdre(){
        List<OrdreEntity> ordreEntities = ordreRepository.findAll();
        for (OrdreEntity ordre : ordreEntities) {
            if(ordre.getTypeOrdre()== TypeOrdre.ACHAT){
                if(  ordre.getAction().getVolume() < ordre.getVolume() ||   ordre.getPortfeuille().getSolde() < ordre.getMontant()  ){
                    System.out.println("solde insuffisant ou actions non disponoble");
                    ordre.setStatut(Statut.BLOQUE);
                    ordreRepository.save(ordre);
                }else{
                    ordre.getPortfeuille().setSolde(ordre.getPortfeuille().getSolde() - ordre.getMontant());
                    ordre.getAction().setVolume(ordre.getAction().getVolume() - ordre.getVolume());
                    ordreRepository.save(ordre);
                }
            }else{

                    ordre.getPortfeuille().setSolde(ordre.getPortfeuille().getSolde() + ordre.getMontant());
                    ordre.getAction().setVolume(ordre.getAction().getVolume() + ordre.getVolume());
                    ordreRepository.save(ordre);

            }
        }
    }

}
