package com.company;

import java.util.*;

public class Grille {
	
	// Attributs
	private int nbLig;
	private int nbCol;
	private String [][] grille;
	
	// Constructeur
	public Grille(int n, int p) {
		nbLig = n;
		nbCol = p;
		grille = new String[nbLig][nbCol];
		
		for (int i = 0; i < nbLig; i++) {
			for(int j = 0; j < nbCol; j++) {
				
				grille[i][j]= "..";
				
			}
		}
	}
	
	// Accesseurs
	public String getCase(int l, int c) {
		return grille[l][c];
	}
	
	// Méthodes
	public void afficher() {
		System.out.println();
		for(int i=0; i<nbLig; i++) {
			for(int j=0; j<nbCol; j++) {
				System.out.print(" | " + grille[i][j]);
			}
			
			System.out.println(" | ");
		}
		
		System.out.println();
	}
	
	public void placer(int l, int c, String t) {
		
		l = l - 1;
		c = c - 1;
		
		// on test si on se trouve bien sur la grille
		if (l < 0 || c < 0 || l > nbLig || c > nbCol) {
			System.out.print("Erreur ");
			return;
		}
		
		if( grille[l][c] == "..") {
			
			grille[l][c] = t;
			
		} else {
			System.out.println("Erreur, cet zone n'est pas vite ! ");
		}
	}
	
	// déplace en hauteur 
	public void deplacerH() {
		
		String tmp; 
		
		for(int i=0; i<nbLig; i++) {
			
			for(int j=0; j<nbCol; j++) {
				
				if(grille[i][j] == "\uD83D\uDE01") { // on cherche le joueur 
					
					if (i -1 >= 0 && grille[i -1][j] == ".." ) { // on test la position 
						
						tmp = grille[i][j]; // on copie le perso 
						grille[i][j] = ".."; // on vide la case
						grille[i - 1][j] = tmp; // on déplace le perso
						System.out.println("\n\nhaut = '2' - bas = '5' - gauche = '4' - droite = '3'");
					} else {
						System.out.println("haut = '2' - bas = '5' - gauche = '4' - droite = '3' - combatre '1'");
					}
				}
			}
		}
	}
	
	// déplace vers la gauche 
	public void deplacerG() {
		
		String tmp; 
		
		for(int i=0; i<nbLig; i++) {
			
			for(int j=0; j<nbCol; j++) {
				
				if(grille[i][j] == "\uD83D\uDE01") { // on cherche le joueur 
					
					if (j -1 >= 0 && grille[i][j-1] == "..") { // on test la position 
						
						tmp = grille[i][j]; // on copie le perso 
						grille[i][j] = ".."; // on vide la case
						grille[i][j -1] = tmp; // on déplace le perso
						System.out.println("\n\nhaut = '2' - bas = '5' - gauche = '4' - droite = '3'");
					} else {
						System.out.println("haut = '2' - bas = '5' - gauche = '4' - droite = '3' - combatre '1'");
					}
				}
			}
		}
	}
	
	// déplace vers la droite
	public void deplacerD() {
		
		String tmp; 
		
		for(int i=0; i<nbLig; i++) {
			
			for(int j=0; j<nbCol; j++) {
				
				if(grille[i][j] == "\uD83D\uDE01") { // on cherche le joueur 
					
					if (j+1 <= nbCol && grille[i][j+1] == "..") { // on test la position 
						
						tmp = grille[i][j]; // on copie le perso 
						grille[i][j] = ".."; // on vide la case
						grille[i][j+1] = tmp; // on déplace le perso
						System.out.println("\n\nhaut = '2' - bas = '5' - gauche = '4' - droite = '3'");
						return;
					} else {
						System.out.println("haut = '2' - bas = '5' - gauche = '4' - droite = '3' - combatre '1'");
					}
				}
			}
		}
	}
	
	// déplace vers en bas
		public void deplacerB() {
			
			String tmp; 
			
			for(int i=0; i<nbLig; i++) {
				
				for(int j=0; j<nbCol; j++) {
					
					if(grille[i][j] == "\uD83D\uDE01") { // on cherche le joueur 
						
						if (i+1 <= nbLig && grille[i+1][j] == ".." ) { // on test la position 
							
							tmp = grille[i][j]; // on copie le perso 
							grille[i][j] = ".."; // on vide la case
							grille[i+1][j] = tmp; // on déplace le perso
							System.out.println("\n\nhaut = '2' - bas = '5' - gauche = '4' - droite = '3'");
							return;
						} else {
							System.out.println("haut = '2' - bas = '5' - gauche = '4' - droite = '3' - combatre '1'");
						}
					}
				}
			}
		}
	
}