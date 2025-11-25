package com.example.demo.Entitiy;

import org.antlr.v4.runtime.misc.Triple;
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