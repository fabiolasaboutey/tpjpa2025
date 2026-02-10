package jpa.domain;

import jakarta.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Concert concert;

    private String seatNumber;
    private String buyerEmail;

    public Ticket() {}
    public Ticket(String seatNumber, String buyerEmail){
        this.seatNumber = seatNumber;
        this.buyerEmail = buyerEmail;
    }
}
