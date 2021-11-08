package com.company;

public abstract class Personnage {

    protected int mVie;
    protected int mForce;
    protected final String mNom;
    protected String mVulnerabilite;

    protected Personnage(int vie, int force, String nom, String vulnerabilite) {
        this.setVie(vie);
        this.setForce(force);
        this.mNom = nom;
        this.mVulnerabilite = vulnerabilite;

    }

    // Si l'arme utilisé est la bonne sinon ne fait rien
    public String getVulnerabilite() {return mVulnerabilite;}

    public int getVie() {return mVie;}
    public void setVie(int vie) {
            this.mVie = vie;
    }

    public String getNom() {return mNom;}

    public int getForce() { return mForce;}
    public void setForce(int mForce) { this.mForce = mForce;}



    public int taper(Personnage ennemi, String arme) {
        if (ennemi.getVulnerabilite() == null || ennemi.getVulnerabilite().equals(arme)) {
            int degat = getForce();
            ennemi.setVie(ennemi.getVie() - degat);
            return degat;
        }
        return 0;
}

// Ajouter a l'histoire
public void presentation() {
    System.out.println("Je suis un" + mNom + " et j'ai" + mVie + " points de vie ");
    System.out.println("Mon épée fait" + mForce + " points de degats. ");
    System.out.println("");
}

public void info() {
    System.out.println("Il me reste " + mVie + " points de vie, je peux continuer l'aventure");
}

}