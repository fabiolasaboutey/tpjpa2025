package jpa.domain;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@NamedQuery(name="Concert.findAllByArtist", query = "SELECT c FROM Concert c WHERE c.artist = :name")
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String artist;
    private String location;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private double price;

    @ManyToOne
    @JoinColumn(name = "organisator_id")
    private Organizer organizer;

    public Concert() {}

    public Concert(String artist, String location, Date date, double price, Organizer organizer) {
        this.artist = artist;
        this.location = location;
        this.date = date;
        this.price = price;
        this.organizer = organizer;
    }

    // Standard Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getArtist() { return artist; }
    public void setArtist(String artistName) { this.artist = artistName; }

    public String getLocation() { return location; }
    public void setLocation(String venue) { this.location = venue; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public Organizer getOrganizer() { return organizer; }
    public void setOrganizer(Organizer organizer) { this.organizer = organizer; }
}