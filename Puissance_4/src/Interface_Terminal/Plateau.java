/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface_Terminal;

import java.util.Scanner;



/**
 *
 * @author TOSHIBA
 */
public class Plateau {
 private int nbrColones;
  private int nbrLignes;
   private static String[][]tableau;
   int taille;
   int colone;
   int ligne;
   //String n="";
    Scanner sc =new Scanner(System.in);
   //private int position;
      public Plateau(){
      this.nbrColones=0;
      this.nbrLignes=0;
       this.tableau=new String[nbrLignes][nbrColones];
      }
   

    public String[][] getTableau() {
        return tableau;
    }

    public void setTableau(String[][] tableau) {
        this.tableau = tableau;
    }

    public int getNbrColones() {
        return nbrColones;
    }

    public void setNbrColones(int nbrColones) {
        this.nbrColones = nbrColones;
    }

    public int getNbrLignes() {
        return nbrLignes;
    }

    public void setNbrLignes(int nbrLignes) {
        this.nbrLignes = nbrLignes;
    }

    
   
    
public  void initialise_grille( ){
    for(int i=1;i<=nbrcol();i++){
        System.out.print(" "+i+" "); 
    }
    for(int i=0;i<nbrlig();i++){
        for(int j=0;j<nbrcol();j++){
            this.tableau[i][j]=" . ";
        }
            }
    //System.out.println();
     System.out.println();
    for(int i=0;i<nbrlig();i++){
        for(int j=0;j<nbrcol();j++){
            // System.out.print met les elements sur la meme  ligne
           System.out.print(this.tableau[i][j]+"");
        }
        System.out.println();
    }
   
    
}


public void afficher(){
     for(int i=1;i<=nbrcol();i++){
        System.out.print(" "+i+" "); 
    }
    System.out.println();
    //System.out.println( " 1  2  3  4  5  6  7 " );
    for(int i=0;i<nbrlig();i++){
        for(int j=0;j<nbrcol();j++){
            // System.out.print met les elements sur la meme  ligne
            System.out.print(tableau[i][j]+"");
        }
        System.out.println();
    }
    System.out.println();
}
 public int nbrlig(){
        return Menu.ligne;
    }
    public int nbrcol(){
        return Menu.colones;
    }
//public int nbrColone
        }
