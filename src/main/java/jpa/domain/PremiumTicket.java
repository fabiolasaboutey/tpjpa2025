package jpa.domain;

import jakarta.persistence.Entity;

@Entity
public class PremiumTicket extends Ticket {
    private String vipService; // ex: "Open Bar", "Backstage access"

    public PremiumTicket() {}

    public String getVipService() {
        return vipService;
    }

    public void setVipService(String vipService) {
        this.vipService = vipService;
    }
}