package tn.esprit.examen.nomPrenomClasseExamen.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.nomPrenomClasseExamen.entities.*;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.ActionRepository;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.ElementRepository;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.OrdreRepository;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.PortfeuilleRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;

@RequestMapping("examen")
@RestController
@AllArgsConstructor
@Slf4j
public class ExamanController {


    ActionRepository actionRepository;
    ElementRepository elementRepository;
    OrdreRepository ordreRepository;
    PortfeuilleRepository portfeuilleRepository;

    @PostMapping("/action")
    public List<ActionEntity> addActions(@RequestBody List<ActionEntity> actions) {
        return actionRepository.saveAll(actions);
    }
    @PostMapping("/portfeuille")
    public PortfeuilleEntity addActions(@RequestBody PortfeuilleEntity portfeuille) {
       elementRepository.saveAll(portfeuille.getElements());
       return portfeuilleRepository.save(portfeuille);
    }

    @PostMapping("/ordre")
    public OrdreEntity addOrdreAndAffectToActionAndPortfeuille(@RequestBody OrdreEntity ordre, @PathVariable String symbole,@PathVariable int reference) {
        log.info("L'ordre est en train detre traité");
      PortfeuilleEntity  portfeuille=portfeuilleRepository.findByReference(reference);
      ActionEntity action=actionRepository.findBySymbol(symbole);
      ordre.setAction(action);
      ordre.setPortfeuille(portfeuille);
      ordre.setStatut(Statut.EN_ATTENTE);
      ordre.setDateCreation(new Date());
      if(ordre.getTypeOrdre()== TypeOrdre.ACHAT){
          ordre.setMontant(ordre.getAction().getPrixAchatActuel()*ordre.getVolume());
      }else{
          ordre.setMontant(ordre.getAction().getPrixVenteActuel()*ordre.getVolume());
      }
      return ordreRepository.save(ordre);

    }

    @GetMapping("actions/{refrence}/{startDate}/{endDate}")
    public List<String> listSymbols(@PathVariable int refrence, @PathVariable Date startDate, @PathVariable Date endDate) {
        return actionRepository.findSymbols(refrence,startDate,endDate);
    }

}
