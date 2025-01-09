package tn.esprit.examen.nomPrenomClasseExamen.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class ActionEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idAction;
    private float prixAchatActuel;
    private float prixVenteActuel;
    private int volume;
    private Date dateEmission;

    @Column(unique=true)
    private String symbol;

    @OneToMany(mappedBy = "action")
    private List<OrdreEntity> orders;

    public Long getIdAction() {
        return idAction;
    }

    public void setIdAction(Long idAction) {
        this.idAction = idAction;
    }

    public float getPrixAchatActuel() {
        return prixAchatActuel;
    }

    public void setPrixAchatActuel(float prixAchatActuel) {
        this.prixAchatActuel = prixAchatActuel;
    }

    public float getPrixVenteActuel() {
        return prixVenteActuel;
    }

    public void setPrixVenteActuel(float prixVenteActuel) {
        this.prixVenteActuel = prixVenteActuel;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Date getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(Date dateEmission) {
        this.dateEmission = dateEmission;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public List<OrdreEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdreEntity> orders) {
        this.orders = orders;
    }
}
