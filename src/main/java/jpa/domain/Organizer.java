package jpa.domain;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;

    // La relation One-to-Many : un organisateur pour plusieurs concerts
    @OneToMany(mappedBy = "organizer", cascade = CascadeType.PERSIST)
    private List<Concert> concerts = new ArrayList<>();

    public Organizer() {
    }

    public Organizer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nom) {
        this.name = nom;
    }


    public List<Concert> getConcerts() {
        return concerts;
    }

    public void setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
    }

}