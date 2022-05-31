package com.company;

public class Tariff {
    private String destination;
    private int pricePerMinute;

    public Tariff(String destination, int pricePerMinute) {
        this.destination = destination;
        this.pricePerMinute = pricePerMinute;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getPricePerMinute() {
        return pricePerMinute;
    }

    public void setPricePerMinute(int pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }
}
