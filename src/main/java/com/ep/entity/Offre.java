package com.ep.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Offre {

    @Id private int id;
    @ManyToOne()
    @JoinColumn(name = "trajet_id")
    private Vol trajet; // vol
    @ManyToOne()
    @JoinColumn(name = "operateur_id")
    private Operateur operateur;
    private String depart; // date et heure
    private double prixBase;

    public Offre() {}
    public Offre(Vol trajet, String depart, double prixBase) {
        this.trajet = trajet; this.depart = depart; this.prixBase = prixBase;
    }

    // getters
    public int getId() { return id; }
    public Vol getTrajet() {return trajet; }
    public Operateur getOperateur() { return operateur; }
    public String getDepart() { return depart; }
    public double getPrixBase() { return prixBase; }

    // setters
    public void setId(int id) { this.id = id; }
    public void setTrajet(Vol trajet) {this.trajet = trajet;}
    public void setOperateur(Operateur operateur) { this.operateur = operateur; }
    public void setDepart(String depart) { this.depart = depart; }
    public void setPrixBase(double prixBase) { this.prixBase = prixBase; }

}
