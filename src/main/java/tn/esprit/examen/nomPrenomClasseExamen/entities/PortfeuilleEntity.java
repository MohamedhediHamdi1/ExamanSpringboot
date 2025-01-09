package tn.esprit.examen.nomPrenomClasseExamen.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class PortfeuilleEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idPortfeuille;

    @Column(unique=true)
    private int reference;
    private float solde;

    @OneToMany(mappedBy = "portfeuille")
    private List<ElementPortfeuilleEntity> elements;
    @OneToMany(mappedBy = "portfeuille")
    private List<OrdreEntity> orders;

    public Long getIdPortfeuille() {
        return idPortfeuille;
    }

    public void setIdPortfeuille(Long idPortfeuille) {
        this.idPortfeuille = idPortfeuille;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public List<ElementPortfeuilleEntity> getElements() {
        return elements;
    }

    public void setElements(List<ElementPortfeuilleEntity> elements) {
        this.elements = elements;
    }

    public List<OrdreEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdreEntity> orders) {
        this.orders = orders;
    }
}
