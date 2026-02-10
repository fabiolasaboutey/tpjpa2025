package jpa.domain;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Organisator {

    private Long id;
    private String nom;
    private String email;

    private List<Concert> concerts = new ArrayList<Concert>();

    public Organisator() {
    }

    public Organisator(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @OneToMany(mappedBy = "organisator", cascade = CascadeType.PERSIST)
    public List<Concert> getConcerts() {
        return concerts;
    }

    public void setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
    }

}