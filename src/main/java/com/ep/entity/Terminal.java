package com.ep.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

public class Terminal {
     @Id
    private int id;

    private String code;

    private String ville;

    private String typeTrajet; //air ou fer

    public Terminal() {}
    public Terminal(String code, String ville , String typeTrajet) {
        this.code = code; 
        this.ville = ville;
        this.typeTrajet = typeTrajet;
    }

    // getters
    public int getId() { return id; }
    public String getCode() { return code; }
    public String getVille() { return ville; }
    public String getTypeTrajet() { return typeTrajet; }

    // setters
    public void setId(int id) { this.id = id; }
    public void setCode(String code) { this.code = code; }
    public void setVille(String ville) { this.ville = ville; }
    public void setTypeTrajet(String typeTrajet) { this.typeTrajet = typeTrajet; }
}
