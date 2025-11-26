package com.example.demo.Entity;

public enum Typechambre {
    SIMPLE(1),
    DOUBLE(2),
    TRIPLE(3);

    private final int capacite;

    Typechambre(int capacite) {
        this.capacite = capacite;
    }

    public int getCapacite() {
        return capacite;
    }
}