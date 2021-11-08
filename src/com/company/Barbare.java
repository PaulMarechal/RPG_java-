package com.company;

import java.util.Random;

public class Barbare extends Ennemi {

    Random random = new Random();

        public Barbare() {
            super(200, 10, "Ennemi", Arme.Sword);
        }

    @Override
    public int getForce() {

        // Méthode pour le coup critique
        int force = super.getForce();
        int coupCritique = (random.nextInt(10)+1);
        if (coupCritique== 1 || coupCritique == 2 || coupCritique == 3) {
            force = (int) (force * 1.3);
        }
        return force;
    }
}

