package com.company;

public class Donjon {
    private Salle[] mSalles;
    public Donjon(Salle[] salles) {
        mSalles = salles;

    }

    public Salle[] getSalles() {
        return mSalles;
    }
}
