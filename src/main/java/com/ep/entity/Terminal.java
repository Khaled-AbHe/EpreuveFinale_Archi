package com.ep.entity;

import jakarta.persistence.*;

@Entity
public class Terminal {
    @Id
    private int id;

    private String code;
    private String ville;

    @Column(name = "typetrajet")
    @Enumerated(EnumType.STRING)
    private TypeTransport typeTrajet; // AERIEN ou FERROVIAIRE

    public Terminal() {}
    public Terminal(String code, String ville, TypeTransport typeTrajet) {
        this.code = code; 
        this.ville = ville;
        this.typeTrajet = typeTrajet;
    }

    // getters
    public int getId() { return id; }
    public String getCode() { return code; }
    public String getVille() { return ville; }
    public TypeTransport getTypeTrajet() { return typeTrajet; }

    // setters
    public void setId(int id) { this.id = id; }
    public void setCode(String code) { this.code = code; }
    public void setVille(String ville) { this.ville = ville; }
    public void setTypeTrajet(TypeTransport typeTrajet) { this.typeTrajet = typeTrajet; }
}
