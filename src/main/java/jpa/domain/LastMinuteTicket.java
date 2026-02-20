package jpa.domain;


import jakarta.persistence.Entity;

@Entity
public class LastMinuteTicket extends Ticket {
    private double discountPercentage;

    public LastMinuteTicket() {}
}