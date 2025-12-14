package com.ep.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Operateur {

    @Id
    private int id;

    private String code; // ≤ 6 caractères, unique

    private String nom;

    public Operateur() {}
    public Operateur(String code, String nom) { this.code = code; this.nom = nom; }

    // getters
    public int getId() { return id; }
    public String getCode() { return code; }
    public String getNom() { return nom; }

    // setters
    public void setCode(String code) { this.code = code; }
    public void setNom(String nom) { this.nom = nom; }

}
