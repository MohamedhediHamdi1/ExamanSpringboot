package tn.esprit.examen.nomPrenomClasseExamen.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class OrdreEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idOrdre;
    private int volume;
    private Date dateCreation;
    private LocalDate dateExecution;
    private float montant;

    @Enumerated(EnumType.STRING)
    private Statut statut;
    @Enumerated(EnumType.STRING)
    private TypeOrdre typeOrdre;

    @ManyToOne
    private PortfeuilleEntity portfeuille;

    @ManyToOne
    private ActionEntity action;


    public Long getIdOrdre() {
        return idOrdre;
    }

    public void setIdOrdre(Long idOrdre) {
        this.idOrdre = idOrdre;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDate getDateExecution() {
        return dateExecution;
    }

    public void setDateExecution(LocalDate dateExecution) {
        this.dateExecution = dateExecution;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public TypeOrdre getTypeOrdre() {
        return typeOrdre;
    }

    public void setTypeOrdre(TypeOrdre typeOrdre) {
        this.typeOrdre = typeOrdre;
    }

    public PortfeuilleEntity getPortfeuille() {
        return portfeuille;
    }

    public void setPortfeuille(PortfeuilleEntity portfeuille) {
        this.portfeuille = portfeuille;
    }

    public ActionEntity getAction() {
        return action;
    }

    public void setAction(ActionEntity action) {
        this.action = action;
    }
}
