package jpa.domain;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String artistName;
    private String venue;

    @Temporal(TemporalType.TIMESTAMP) // Clearly defines the DB format
    private Date date;

    private double price;

    @ManyToOne
    @JoinColumn(name = "organisator_id") // Maps the foreign key column
    private Organisator organisator;

    public Concert() {}

    public Concert(String artistName, String venue, Date date, double price, Organisator organisator) {
        this.artistName = artistName;
        this.venue = venue;
        this.date = date;
        this.price = price;
        this.organisator = organisator;
    }

    // Standard Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getArtistName() { return artistName; }
    public void setArtistName(String artistName) { this.artistName = artistName; }

    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public Organisator getOrganisator() { return organisator; }
    public void setOrganisator(Organisator organisator) { this.organisator = organisator; }
}