/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Joueur;

import Interface_Terminal.Menu;
import Interface_Terminal.Plateau;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author TOSHIBA
 */
public class IA implements Joueur{
   private  String name;
     static Scanner sc=new Scanner(System.in);
     private Plateau p;
    private String pion;
    public static  String h;
    public static  String hi;
     public static  String his;
    public static  String name1;
    public static  String name2;
    public static  String name3;
    public static  String n1;
    public static  String n2;
    public static  String n3;
    int cols;
     public IA(){
         this.pion=" o ";
         this.p=new Plateau();
         this.name=null;
         
     }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;  
    }
     
     public void iaLevelOne(String pion){
        //jeu.afficher();
        name1="Joueur_2 est IA: Overhaul";
        n1="Overhaul";
        Random rand = new Random();
        int upperbound = Menu.colones;
        int int_random = rand.nextInt(upperbound);
        
        
        for (int col = int_random; col <Menu.colones; col++){
            cols=col+1;
            his="$ joueur_2 joue :"+cols;
            
           jouer("Joueur_2",pion,col+1); 
           break;
        }
        System.out.println();
        System.out.println();
    }
      public void iaLevel2(String pion ){
        //jeu.afficher();
        name2="Joueur_3 est IA: Shigaraki";
        n2="Shigaraki";
        Random rand = new Random();
        int upperbound = Menu.colones;
        int int_random = rand.nextInt(upperbound);
        if(contreIaLevel1("Shigaraki",pion)){
           // System.out.println("con");
            
        }else{
        for (int col = int_random; col <Menu.colones; col++){
             cols=col+1;
             hi="$ Joueur_3 joue :"+cols;
           jouer("Joueur_3",pion,cols);
           
           break;
        }
        System.out.println();
        System.out.println();
        }
    }
       public void iaLevel3(String pion ){
        //jeu.afficher();
        name2="Joueur_4 est IA: All_For_One";
        n3="All_For_One";
        Random rand = new Random();
        int upperbound = Menu.colones;
        int int_random = rand.nextInt(upperbound);
        if(contreIaLevel2(pion)){
          // System.out.println("con");
            
        }else{
        for (int col = int_random; col <Menu.colones; col++){
             cols=col+1;
             h="$ Joueur_4 joue :"+cols;
           jouer("Joueur_4",pion,cols);
           
           break;
        }
        System.out.println();
        System.out.println();
        }
    }
     public void jouer(String nom,String pions,int jeu){
         System.out.println("$ "+jeu); 
         int jeu_1;
 int col;
   
  //int col;
if(jeu>=0 && jeu<=Menu.colones){
   // System.out.println("Jeu "+jeu);
    col=jeu-1;
    if(p.getTableau()[0][col]!=" . "){
        System.out.println("La colonne est pleine"); 
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
}
    p.afficher();
 
}
     public boolean contreIaLevel1(String nom,String pions){
        //horizontally
        if(pions==" o "){
            pion=" x ";
        }else if(pions==" x "){
            pion=" o ";
        }
         for(int i=Menu.ligne-1;i>=0;i--){
             for(int j=0;j<=Menu.colones-3;j++){
                
                if(p.getTableau()[i][j]==pion && p.getTableau()[i][j+1]==pion && p.getTableau()[i][j+2]==pions){
                }else{
                if(p.getTableau()[i][j]==pion && p.getTableau()[i][j+1]==pion){
                    jouer(nom,pions,j+3); 
                    hi="$ Joueur_3 joue :"+cols;
               return true;
             }
                }
         }
             
     }
          //vertically
         for(int i=Menu.ligne-1;i>=2;i--){
             for(int j=0;j<=Menu.colones-1;j++){
                 if(p.getTableau()[0][j]!=" . "){
                }else{
                     if(p.getTableau()[i][j]==pion && p.getTableau()[i-1][j]==pion &&  p.getTableau()[i-2][j]==pions){
                     }else{
                 if(p.getTableau()[i][j]==pion && p.getTableau()[i-1][j]==pion){
                     System.out.println("yo");
                    jouer(nom,pions,j+1); 
                    hi="$ Joueur_3 joue :"+cols;
                    
               return true;
              
                        }
         
             }
                 }
                 }
             }
     
         //oblique bas ver up
//          for(int i=Menu.ligne-1;i>=2;i--){
//             for(int j=0;j<=Menu.colones-3;j++){
////                 System.out.println(i);
////                 System.out.println(j);
//                 if(p.getTableau()[i][j]==" x " && p.getTableau()[i-1][j+1]==" x "){
//                    jouer("Shigaraki"," o ",j+1); 
//                    hi="$ Joueur_3 joue :"+cols;
//               return true;
//             }
//         }
//     }
return false;
        
     }
     public boolean contreIaLevel2(String pions){
         if(pions==" o "){
             pion=" x ";
         }else if(pions==" x "){
             pion=" o ";
         }
        if(contreIaLevel1("All_For_One",pions)){
            //System.out.println("yes");  
            return true;
        } else{
            //System.out.println("no");
            //gagner horizontalement
            for(int i=Menu.ligne-1;i>=0;i--){
                for(int j=0;j<Menu.colones-3;j++){
                    if(p.getTableau()[i][j]==pions && p.getTableau()[i][j+1]==pions && p.getTableau()[i][j+2]==pion){
                        
                     break;   
                    }else{
                    if(p.getTableau()[i][j]==pions && p.getTableau()[i][j+1]==pions){
                        jouer("All_For_One", pions, j+3);
                        return  true;
                    }
                    }
                }
            }
            
            
        }
         return  false;
     }
     
     
     
         
}
