package jpa.domain;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Ticket {
    @Id
    @GeneratedValue
    private Long id;

    private String seatNumber;
    private String buyerEmail;

    @ManyToOne
    private Concert concert;



    public Ticket() {}
    public Ticket(String seatNumber, String buyerEmail){
        this.seatNumber = seatNumber;
        this.buyerEmail = buyerEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }
}
