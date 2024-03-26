/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface_Terminal;

import Gestionnaire.Gestionnaire_Partie;
import Joueur.Humain;
import java.util.Scanner;

/**
 *
 * @author TOSHIBA
 */
public class Menu {
       private Plateau p;
    private Humain h;
    Scanner sc=new Scanner(System.in);
    String reponse_1;
    String reponse_2;
    String reponse_3;
    String reponse_4;
    String reponse_5;
    String reponse_6;
  public static String pion1;
  public static String pion2;
  public static int nbrMan;
  public  static int ligne;
  public static int colones;
  public static int numIa;
  public static int numIa1;
  public static int numIa2;
    public Menu() {
        this.p = new Plateau();
        this.h=new Humain();
    }
    public void menuDemarrage(){
        System.out.println("                **************************************                    ");
        System.out.println("                **                                  **                    ");
        System.out.println("                **           Puissance_4            **                    ");
        System.out.println("                **                                  **                    ");
        System.out.println("                **************************************                    ");
        System.out.println("                                                                          ");
        System.out.println("*--------------------Bienvenue dans Puissance_4--------------------------*");
        System.out.println("*                            1- Jouer                                    *");
        System.out.println("*                            2- Quitter                                  *");
        System.out.println("*-------------------Veuiller entrer le numero correspondant--------------*");
        reponse_1=sc.next();
        if(Gestionnaire_Partie.isNumeric(reponse_1)){
        if(Integer.parseInt(reponse_1)==1){
        choixPartie();
        
        }else if(Integer.parseInt(reponse_1)==2){
            System.exit(0);
        }else{
            System.err.println("Erreur de saisie "+reponse_1);
            menuDemarrage();
        }
        }else{
            System.err.println("Erreur saisie "+reponse_1); 
             menuDemarrage();
                }
    }
    public int respond(){
        return Integer.parseInt(reponse_2);
    }
    
    public void choixPartie(){
        System.out.println("*-----------------------Choix type de partie-----------------------------*");    
        System.out.println("*                      1- Player_1 VS Player_2                           *");
        System.out.println("*                      2- Player VS IA                                   *");
        System.out.println("*                      3- IA VS IA                                       *");
        System.out.println("*--------------------Veuiller entrer le numero correspondant-------------*");
        reponse_2=sc.next();
        if(Gestionnaire_Partie.isNumeric(reponse_2)){
            
         if(Integer.parseInt(reponse_2)==1){
              choixGrillePlVSP2();
             
        }else if(Integer.parseInt(reponse_2)==2){
            choixIa();
           choixGrillePlVSIA();
            
        }else if(Integer.parseInt(reponse_2)==3){
         System.out.println("*-----------------------Choix Level des IA-----------------------------*"); 
         System.out.println("*----------------------Choix Level joueur_1 IA-------------------------*"); 
            choixIa();
            numIa1=Integer.parseInt(reponse_5);
            
            System.out.println("*----------------------Choix Level joueur_2 IA-------------------------*"); 
            choixIa();
            
            numIa2=Integer.parseInt(reponse_5);
            if(numIa2==numIa1){
                System.err.println("IA_1 ne peut pas joueur contre IA_2");
               choixPartie(); 
            }
           choixGrilleIAVSIA();
            
           System.out.println("*--------------------------------------------------------------------*"); 
        }else{
             System.err.println("Erreur saisie "+reponse_2);
           choixPartie();
        }
         }else{
             System.out.println("Erreur saisie "+reponse_2);
             choixPartie();
         }
    }
    public void choixGrillePlVSP2(){
         System.out.println("*-----------------------Choix taille grille-----------------------------*");
         System.out.println("*                         1- Grille : 7x6                               *");
         System.out.println("*                         2- Grille : 8x8                               *");
         System.out.println("*                         3- Grille : 10x10                             *");
         System.out.println("*-------------------Veuiller entrer le numero correspondant-------------*");
         reponse_3=sc.next();
         if(Gestionnaire_Partie.isNumeric(reponse_3)){
             if(Integer.parseInt(reponse_3)==1){
                 ligne=6; 
                 colones=7;
                 mancheGangner();
                h.nom_joueur();
                p.setTableau(new String[ligne][colones]);
                p.initialise_grille();
                
             }else if(Integer.parseInt(reponse_3)==2){
               ligne=8;
                 colones=8;
                 mancheGangner();
                  h.nom_joueur();
                  p.setTableau(new String[ligne][colones]);
                p.initialise_grille();
                
             }else if(Integer.parseInt(reponse_3)==3){
                  ligne=10;
                 colones=10;
                 mancheGangner();
                  h.nom_joueur();
                  p.setTableau(new String[ligne][colones]);
                p.initialise_grille();
                
             }else{
                 System.err.println("Erreur saisie "+reponse_3);
                 choixGrillePlVSP2();
             }
             }else{
                 System.err.println("Erreur saisie "+reponse_3);
                 choixGrillePlVSP2();
             }
          
    }
    public void choixGrillePlVSIA(){
         System.out.println("*-----------------------Choix taille grille-----------------------------*");
         System.out.println("*                         1- Grille : 7x6                               *");
         System.out.println("*                         2- Grille : 8x8                               *");
         System.out.println("*                         3- Grille : 10x10                             *");
         System.out.println("*-------------------Veuiller entrer le numero correspondant-------------*");
         reponse_3=sc.next();
         if(Gestionnaire_Partie.isNumeric(reponse_3)){
           if(Integer.parseInt(reponse_3)==1){
                 ligne=6;
                 colones=7;
                 mancheGangner();
                 //choixIa();
                h.nomIA();
                p.setTableau(new String[ligne][colones]);
                p.initialise_grille();
                
             }else if(Integer.parseInt(reponse_3)==2){
               ligne=8;
                 colones=8;
                 mancheGangner();
                // choixIa();
                  h.nomIA();
                  p.setTableau(new String[ligne][colones]);
                p.initialise_grille();
                
             }else if(Integer.parseInt(reponse_3)==3){
                  ligne=10;
                 colones=10;
                 mancheGangner();
                 //choixIa();
                  h.nomIA();
                  p.setTableau(new String[ligne][colones]);
                p.initialise_grille();
                
             }else{
                 System.err.println("Erreur saisie "+reponse_3);
                  choixGrillePlVSIA(); 
             }
             }else{
                 System.err.println("Erreur saisie "+reponse_3);
                 choixGrillePlVSIA();
             }
          
    }
    public void choixGrilleIAVSIA(){
         System.out.println("*-----------------------Choix taille grille-----------------------------*");
         System.out.println("*                         1- Grille : 7x6                               *");
         System.out.println("*                         2- Grille : 8x8                               *");
         System.out.println("*                         3- Grille : 10x10                             *");
         System.out.println("*-------------------Veuiller entrer le numero correspondant-------------*");
         reponse_3=sc.next();
          if(Gestionnaire_Partie.isNumeric(reponse_3)){
           if(Integer.parseInt(reponse_3)==1){
                 ligne=6;
                 colones=7;
                  mancheGangner();
                  
                //h.nomIA();
                p.setTableau(new String[ligne][colones]);
                p.initialise_grille();
               
             }else if(Integer.parseInt(reponse_3)==2){
               ligne=8;
               colones=8;
               mancheGangner();
                  //h.nomIA();
                  p.setTableau(new String[ligne][colones]);
                p.initialise_grille(); 
                
             }else if(Integer.parseInt(reponse_3)==3){
                  ligne=10;
                 colones=10;
                 mancheGangner();
                 // h.nomIA();
                  p.setTableau(new String[ligne][colones]);
                p.initialise_grille();
                
             }else{
                 System.err.println("Erreur saisie "+reponse_3);
                  choixGrilleIAVSIA(); 
             }
             }else{
                 System.err.println("Erreur saisie "+reponse_3);
                 choixGrilleIAVSIA();
             }
          
    }
    public void mancheGangner(){
         System.out.println("*---------------Choix nombre manches pour gagner------------------------*");
         System.out.println("*-------------------Veuiller entrer le numero correspondant-------------*"); 
         reponse_4=sc.next();
         if(Gestionnaire_Partie.isNumeric(reponse_4)){
            nbrMan=Integer.parseInt(reponse_4); 
         }else{
             System.err.println("Erreur saisie "+reponse_4);
             mancheGangner();
         }
    }
    public void choixIa(){
         System.out.println("*-------------------------Choix level IA--------------------------------*");
         System.out.println("*                        1- IA_easy :Overhaul                           *");
         System.out.println("*                        2- IA_meduim :Shigaraki                        *");
         System.out.println("*                        3- IA_hard : All_For_One                       *");
         System.out.println("*-------------------Veuiller entrer le numero correspondant-------------*"); 
         reponse_5=sc.next();
         if(Gestionnaire_Partie.isNumeric(reponse_5)){
             if(Integer.parseInt(reponse_5)==1){
                 numIa=1;
                 
             }else if(Integer.parseInt(reponse_5)==2){
                 numIa=2;
             }else if(Integer.parseInt(reponse_5)==3){
                 numIa=3;
             }else{
                 System.err.println("Erreur saisie "+reponse_5);
                 choixIa();
             }
         }else{
             System.err.println("Erreur saisie "+reponse_5);
             choixIa();
         }
         
    }
            
    
}
