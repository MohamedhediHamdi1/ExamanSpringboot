package tn.esprit.examen.nomPrenomClasseExamen.entities;

import jakarta.persistence.*;

@Entity
public class ElementPortfeuilleEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idElement;
    private String symbol;
    private int nombreActions;
    private float prixAchat;

    @ManyToOne
    private PortfeuilleEntity portfeuille;


    public Long getIdElement() {
        return idElement;
    }

    public void setIdElement(Long idElement) {
        this.idElement = idElement;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getNombreActions() {
        return nombreActions;
    }

    public void setNombreActions(int nombreActions) {
        this.nombreActions = nombreActions;
    }

    public float getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(float prixAchat) {
        this.prixAchat = prixAchat;
    }

    public PortfeuilleEntity getPortfeuille() {
        return portfeuille;
    }

    public void setPortfeuille(PortfeuilleEntity portfeuille) {
        this.portfeuille = portfeuille;
    }
}
