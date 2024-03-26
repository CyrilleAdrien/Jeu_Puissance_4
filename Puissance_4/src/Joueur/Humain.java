/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Joueur;

import Gestionnaire.Gestionnaire_Partie;
import Interface_Terminal.Menu;
import Interface_Terminal.Plateau;
import java.util.Scanner;

/**
 *
 * @author TOSHIBA
 */
public class Humain implements Joueur  {
    private  String nom;
    static Scanner sc=new Scanner(System.in);
    static String name2=" ";
    static String name1=" ";
    private Plateau p;
    private int score;
    private String pion;
    private Menu m;
    //private Gestionnaire_Partie g;
    int compteur=1;
    int jeu_1;
    static String ligne;
    String out ;
    int out1 ;
    int lignes;
    int colones;
    public static String h1;
    public static String h2;
    public Humain (){
        this.nom="  ";
        this.p=new Plateau();
        //this.score=0;
        this.pion=" x ";
       // this.m=new Menu();
    }
    public Humain(String n){
     this.nom=n;   
    }

    public  String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

   
    public   void jouer(){
        nom_joueur();
       // tourRole();
        
    }
    public String hist(){
        return ligne;
    }
public void nomIA(){
    System.out.println("joueur_1 ?");
 name1=sc.nextLine();
  h1="Joueur_1 est humain: "+name1;
     System.out.println( "$ humain "+name1);
     
}
    public void nom_joueur(){
    System.out.println(" joueur_1 ?");
 name1=sc.nextLine();
 h1="Joueur_1 humain est "+name1; 
    System.out.println( "$ humain "+name1);
  System.out.println(" joueur_2 ?");
 name2=sc.nextLine();
 h2="Joueur_2 humain est "+name2;
 System.out.println( "$ humain "+name2);
   System.out.println("");
   
System.out.println( "$ LA PARTIE A COMMENCE!!!! ");   
}
 public void jouer(String name1,String pions,int jeu){
      
  int col;
if(jeu>=0 && jeu<=Menu.colones){
    col=jeu-1;
    if(p.getTableau()[0][col]!=" . "){
        System.err.println("Erreur colonne pleine "+col); 
        }else{
    for(int i=Menu.ligne-1;i>=1;i--){
    if(p.getTableau()[i][col]==" . " ){
     p.getTableau()[i][col]=pions; 
     break;
    }else if(p.getTableau()[i][col]!=" . "){
        if(p.getTableau()[i-1][col]==" . "){
        p.getTableau()[i-1][col]=pions;
     break;
        }
    }
                }
            }
     p.afficher();
}else if(jeu>Menu.colones || jeu<0){
    System.err.println("Erreur colonne non valide "+jeu); 
    //jouer(name1,pions,jeu);
}
   
 
}   
 
 public String nomPlayer1(){
     return name1;
 }
 public String nomPlayer2(){
     return name2;
 }

}
