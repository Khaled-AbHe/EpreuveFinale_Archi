package com.ep.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Vol {

    @Id
    private int id;

    private String numero;

    @ManyToOne(optional=false) @JoinColumn(name = "origine_id")
    private Aeroport origine;

    @ManyToOne(optional=false) @JoinColumn(name = "destination_id")
    private Aeroport destination;

    private double duree;


    public Vol() {}

    // getters
    public int getId() { return id; }
    public String getNumero() { return numero; };
    public Aeroport getOrigine() { return origine; }
    public Aeroport getDestination() { return destination; }
    public double getDureeMin() { return duree; }

    // setters
    public void setOrigine(Aeroport origine) { this.origine = origine; }
    public void setDestination(Aeroport destination) { this.destination = destination; }
    public void setDureeMin(Integer dureeMin) { this.duree = dureeMin; }
}
