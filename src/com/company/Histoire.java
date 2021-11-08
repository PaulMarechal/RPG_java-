package com.company;

import java.util.Random;
import java.util.Scanner;

public class Histoire {
	
    public int[] surrogates = {0xD83E, 0xDDDF};
    public int[] surrogates1 = {0xD83D, 0xDC7B};
    public int[] surrogates2 = {0xD83E, 0xDDD9};
    public int[] surrogates3 = {0xD83E, 0xDD77};
    
    public String emojiMechant = new String(surrogates, 0, surrogates.length);
    public String emojiMechant1 = new String(surrogates1, 0, surrogates1.length);
    public String emojiMechant2 = new String(surrogates2, 0, surrogates2.length);
    public String emojiHeros = new String(surrogates3, 0, surrogates3.length);

    // Differentes salles du jeu / Array[]
    Scanner scanner = new Scanner(System.in);


private Donjon mDonjon = new Donjon(new Salle[]{
        new Salle("vestibule", new Magicien()),
        new Salle("Boudoir", new Barbare()),
        new Salle("Grand Salon", new Magicien()),
        new Salle("Bibliothèque", new Barbare()),
        new Salle("Salle du boss ! ", new Magicien())});

private Aventurier mAventurier = new Aventurier();

public void run() {
    // si le choix est different de 1 on quitte
    if (!debut()){
    	return;
    }
    for (int i = 0; i < mDonjon.getSalles().length; i++) {
      if  (! salle(mDonjon.getSalles()[i])) {
          System.out.println("T'es mort !");
          return;
      }
    }
    System.out.println("Felicitation !! ");
    System.out.println("Vous avez gagné le tresor du Donjon Hurlant \uD83D\uDC8D\uD83D\uDCB0");
}
    public void menu() {
        System.out.println("—————————————————————————————");
        System.out.println("|           ⚔︎  ⚔            |");
        System.out.println("|      Aventurier & CO      |");
        System.out.println("|                           |");
        System.out.println("|  appuyer sur une touche   |");
        System.out.println("|                           |");
        System.out.println("|             ⏅            |");
        System.out.println("—————————————————————————————");

        Scanner scan = new Scanner(System.in);
        String entreJeu = scan.nextLine();
        if (entreJeu.equals('e')) {
            run();
        }
    }
    // Debut du script
    public boolean debut() {

        System.out.println("Bienvenue à toi jeune Padawan");
        System.out.println("Tu viens d'arriver devant le Donjon Hurlant");
        System.out.println("Il y a devant toi une grande porte en bois et fer forgé qui ferme le donjon.");
        System.out.println("En regardant de plus près il semble que la porte n'est pas verouillée. ");
        System.out.println("Que souhaite tu faire? ");
        

        System.out.println(" 1 - Entrer dans le Donjon ");
        System.out.println(" 2 - Partir en courant ");

        Scanner scan = new Scanner(System.in);
        int choixUtilisateur = scan.nextInt();
        
        if (choixUtilisateur != 1) {
        	System.out.println("Dommage, une prochaine fois...");
        	return false;
        }
		
        Grille g1 = new Grille(10, 10);
        //on place le joueur
        g1.placer(1, 5, "\uD83D\uDE01");
        
        // on place un monstre 
        g1.placer(8, 2, emojiMechant);
        g1.placer(7, 4, emojiMechant1);
        g1.placer(1, 1, emojiMechant2);
        
        
        g1.afficher();
		System.out.println("haut = '2' - bas = '5' - gauche = '4' - droite = '3'");
        
        for(int j=0; j<100; j++) {
        	// on crée la grille 
        	Scanner scan1 = new Scanner(System.in);
        	int choixUtilisateur1 = scan1.nextInt();
			
			if(choixUtilisateur1 == 2) { // on cherche le joueur 
				 g1.deplacerH();
		         g1.afficher();
		         continue;
			} else if ( choixUtilisateur1 == 5) {
				g1.deplacerB();
	        	g1.afficher();
	        	continue;
			} else if ( choixUtilisateur1 == 4) {
				g1.deplacerG();
	            g1.afficher();
	            continue;
			} else if ( choixUtilisateur1 == 3 ) {
	            g1.deplacerD();
	            g1.afficher();
	            continue;
			} else if ( choixUtilisateur1 == 1) {
				break;
			} else {
				System.out.println("Ce choix n'est pas valide");
			}
        }
        // Si choix utilisateur est egal a 1 on rentre dans le jeu
        return (choixUtilisateur == 1);
    }


    private boolean salle(Salle salle) {

    	// Méthode pour le jeu de role - précise la vie du joueur/ennemi + vie joueur/ennemi
    	Ennemi ennemi = salle.getEnnemi();
        System.out.println("Le combat contre un " + ennemi.getNom() + " va commencer ! En garde ! ");
        System.out.println("");
        System.out.println("        X ");
        System.out.println(" |_O   / \\  O_\\");
        System.out.println("   |`-/   \\-'\\");
        System.out.println("   |\\       / |");
        System.out.println("  /  |      |  \\");
        System.out.println("");
       

	
        while(mAventurier.getVie() > 0 && ennemi.getVie() > 0) {
            System.out.println("Que souhaite tu faire : ");
            System.out.println("Tape au clavier pour entrer la reponse ");
            System.out.println(Arme.Sword + " : Taper à l'épée");
            System.out.println(Arme.Water_Flask + " : envoyer une grenade ");
            
            

            // Combat : demande de choisir quel arme on souhaite utiliser
            // indique la vie et la force de l'attaque
            String choix = scanner.nextLine();
            if (choix.equals(Arme.Water_Flask) || choix.equals(Arme.Sword)) {
                int degat = mAventurier.taper(ennemi, choix);
                if (degat == 0 ) {
                    System.out.println("Cela ne fait rien contre ce monstre..");
                } else {
                    System.out.println("Tu viens de lui infliger " + degat + " de degat, il lui reste " + ennemi.getVie());
                }
                // L'aventurier est vulnérable a toutes les armes
                degat = ennemi.taper(mAventurier, null);
                System.out.println("Il t'a fait perdre " + degat + " points de vie ");
                System.out.println("Il te reste " + mAventurier.getVie() + " de vie ");
                System.out.println("");

            } else {
                System.out.println("Cette arme n'est pas valide.. ");
                continue;
            }
            System.out.println("Felicitation tu viens de passer la salle : " + salle.getNom());

            System.out.println("");
            System.out.println("   //");
            System.out.println("  /_O  X");
            System.out.println("   /`-/ \\   O_\\");
            System.out.println("  | \\    \\-'_\\");
            System.out.println(" /  /       \\ |_");
            System.out.println("");

        }
        if (mAventurier.getVie() > 0) {
            
            Grille g1 = new Grille(10, 10);
            
          //on place le joueur
            g1.placer(1, 5, "\uD83D\uDE01");
            
            // on place un monstre avec des coordonnées aléatoires 
            Random random = new Random();
            int nb, nb1, nb2;
            nb = random.nextInt(9) + 1;
            nb1 = random.nextInt(9) + 2;
            nb2 = random.nextInt(10);
            
            g1.placer(nb, nb1, emojiMechant);
            g1.placer(nb1, nb, emojiMechant1);
            g1.placer(nb2, nb1, emojiMechant2);
            g1.afficher();
            
            System.out.println("haut = '2' - bas = '5' - gauche = '4' - droite = '3'");
            
            for(int j=0; j<100; j++) {
            	// on crée la grille 
            	
            	Scanner scan2 = new Scanner(System.in);
            	int choixUtilisateur2 = scan2.nextInt();
    			
    			if(choixUtilisateur2 == 2) { // on cherche le joueur 
    				 g1.deplacerH();
    		         g1.afficher();
    		         continue;
    			} else if ( choixUtilisateur2 == 5) {
    				g1.deplacerB();
    	        	g1.afficher();
    	        	continue;
    			} else if ( choixUtilisateur2 == 4) {
    				g1.deplacerG();
    	            g1.afficher();
    	            continue;
    			} else if ( choixUtilisateur2 == 3 ) {
    	            g1.deplacerD();
    	            g1.afficher();
    	            continue;
    			} else if ( choixUtilisateur2 == 1) {
    				break;
    			} else {
    				System.out.println("Ce choix n'est pas valide");
    			}
            } 

            return true;
        }else if ( salle.getNom() == "Salle du boss ! ") {
        	return true;
        } else {
            return false;
        }
    }

}