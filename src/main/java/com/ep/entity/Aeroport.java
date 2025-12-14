package com.ep.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Aeroport {

    @Id
    private int id;

    private String code;

    private String ville;

    public Aeroport() {}
    public Aeroport(String code, String ville) {
        this.code = code; this.ville = ville;
    }

    // getters
    public int getId() { return id; }
    public String getCode() { return code; }
    public String getVille() { return ville; }

    // setters
    public void setCode(String code) { this.code = code; }
    public void setVille(String ville) { this.ville = ville; }
}
