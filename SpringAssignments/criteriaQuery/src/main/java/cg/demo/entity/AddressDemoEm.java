package cg.demo.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class AddressDemoEm {
    private int pin;
    private String city;
    private String state;

    public AddressDemoEm() {}

    public AddressDemoEm(int pin, String city, String state) {
        this.pin = pin;
        this.city = city;
        this.state = state;
    }
}