 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestionnaire;

import Interface_Terminal.Menu;
import Interface_Terminal.Plateau;
import Joueur.Humain;
import Joueur.IA;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author TOSHIBA
 */
public class Gestionnaire_Partie {
    private Plateau p;
    private Humain player_1;
    private Humain player_2;
    private Menu m;
    private IA ia;
    private String[]historique;
    String out;
    Scanner sc=new Scanner(System.in);
int compteur=1;
int manche=1;
int score_1=0;
int score_2=0;
int num;
int out1;
int lignes;
int colones;
int his;
int n=2;
int val;
String hist;
String hi;
String nomia;
String nomia1;
String nomia2;
String nouvp;
    public Gestionnaire_Partie() {
        
         this.p = new Plateau();
        this.player_1 =new Humain();
        this.player_2 = new Humain();
        this.m=new Menu();
        this.ia=new IA();
        this.historique=new String[300];
    }
    
    public void tourRolePlayer() throws IOException{ //methode pour le tour de role des parties joueurVSjoueur , joueur VS Ia et IaVSIa
        nomia();
         player_1.setNom(player_1.nomPlayer1());
           player_2.setNom(player_2.nomPlayer2());
           out=null;
   //Joueur Vs Joueur
   if(m.respond()==1){
     while(compteur>0){    
          if(compteur==1){
              //out="";
              System.out.print("$ ");
              out=sc.nextLine();
              //val=Integer.parseInt(out);
              hist="$ Joueur_1 joue :"+ out;
              ajoutHistorique(hist);
              if(out.equals("sortir")){
                  sortir();
              }else if(isNumeric(out)==false){
                 
                  System.err.println("Erreur saisie colonne "+out);
                   hi="Erreur saisie colonne "+out;
       ajoutHistorique(hi);
       tourRolePlayer();
                  
              }else{
               
         player_1.jouer(player_1.getNom()," x ",Integer.parseInt(out));
           
         if(conditionVictoire(" x ",player_1.getNom(),player_2.getNom())){
             //System.out.println( historique);
             break; 
         }
         compteur=2;
              }
     }else if(compteur==2){
         // out="";
              System.out.print("$ ");
              out=sc.nextLine();
              hist="$ Joueur_2 joue :"+ out;
              ajoutHistorique(hist);
              if(out.equals("sortir")){
                 sortir();
              }else if(isNumeric(out)==false){
                 
                  System.err.println("Erreur saisie colonne "+out);
                   hi="Erreur saisie colonne "+out;
       ajoutHistorique(hi);
       tourRolePlayer();
              }else{         
            player_2.jouer(player_2.getNom()," o ",Integer.parseInt(out));
        
        if(conditionVictoire(" o ",player_1.getNom(),player_2.getNom())){
             break;
         }
        compteur=1;
     }
              
     }
 }
     //Joueur Vs Ia
        }else if(m.respond()==2){    
       while(compteur>0){
     if(compteur==1){
         System.out.print("$ ");
              out=sc.next();
              hist="$ Joueur_1 joue :"+ out;
              ajoutHistorique(hist);
              System.out.println(out);
              if(out.equals("sortir")){
                 sortir();
              }else if(isNumeric(out)==false){
                  System.out.println("Erreur saisie colonne "+out);
                   hi="Erreur saisie colonne "+out;
       ajoutHistorique(hi);
       tourRolePlayer();                                                                                                                                                                                                                                                                                    
              }else{
               
         player_1.jouer(player_1.getNom()," x ",Integer.parseInt(out));
           
         if(conditionVictoire(" x ",player_1.getNom(),player_2.getNom())){
             //System.out.println( historique);
             break; 
         }
          compteur=2;
              }
             
     }else if(compteur==2){
         if(Menu.numIa==1){
             ia.iaLevelOne(" o ");
             nomia="Overhaul";
             ajoutHistorique(IA.his);
         }else if(Menu.numIa==2){
           ia.iaLevel2(" o "); 
           nomia="Shigaraki";
           ajoutHistorique(IA.hi);
         }else if(Menu.numIa==3){
             ia.iaLevel3(" o ");
             nomia="All_For_One";
             ajoutHistorique(IA.h);
         }
        
        
         
        if(conditionVictoire(" o ",player_1.getNom(),nomia)){
             break;
         }
        compteur=1;
     }
 } 
       // Ia Vs Ia
        }else if(m.respond()==3){
       while(compteur>0){
     if(compteur==1){
         //test pour savoir si l'Ia selectionne est du niveau 1,2 ou 3
         if(Menu.numIa1==1){
           ia.iaLevelOne(" x ");
           ajoutHistorique(IA.his);
        if(conditionVictoire(" x ",nomia1,nomia2)){
             break;
         }
         }else if(Menu.numIa1==2){
           ia.iaLevel2(" x ");
           ajoutHistorique(IA.hi);
            if(conditionVictoire(" x ",nomia1,nomia2)){
             break;
         }
         }else if(Menu.numIa1==3){
              ia.iaLevel3(" x ");
              ajoutHistorique(IA.h);
              if(conditionVictoire(" x ",nomia1,nomia2)){
             break;
         }
         
         }
         
        compteur=2;
     }else if(compteur==2){
         //test pour savoir si l'Ia selectionne est du niveau 1,2 ou 3
         if(Menu.numIa2==1){
           ia.iaLevelOne(" o ");
           ajoutHistorique(IA.his);
           if(conditionVictoire(" o ",nomia1,nomia2)){
             break;
         }
         }else if(Menu.numIa2==2){
           ia.iaLevel2(" o ");
           ajoutHistorique(IA.hi);
           if(conditionVictoire(" o ",nomia1,nomia2)){
             break;
         }
         }else if(Menu.numIa2==3){
          ia.iaLevel3(" o ");
          ajoutHistorique(IA.h);
          if(conditionVictoire(" o ",nomia1,nomia2)){
             break;
         }
         }
       
        // ajoutHistorique(IA.hi);
        
        compteur=1;
     }
 }   
  
        }
 }
    public boolean conditionVictoire(String pion,String nom1,String nom2) throws IOException{
                //horizontalement
        for(int i=Menu.ligne-1;i>=0;i--){//parcourir les lignes de la grille de jeu
            for(int j=0;j<=Menu.colones-4;j++){//parcourir les colonnes de la grille de jeu
            if((p.getTableau()[i][j]==pion && p.getTableau()[i][j+1]==pion 
           && p.getTableau()[i][j+2]==pion&& p.getTableau()[i][j+3]==pion) //verifie ci 4 pions du meme genre sont alignes sur la meme ligne
            ){
                if(pion==" x "){
                 System.out.println("Victoire de  la manche "+manche+" par "+nom1);
                 hi="Victoire de  la manche "+manche+" par "+nom1;
                    ajoutHistorique(hi);
                 manche=manche+1;//Augmentation du nombre de manches
                score_1=1+score_1;//Augmentation du score du joueur 1
                }else if(pion==" o "){
                  System.out.println("Victoire de  la manche "+manche+" par "+nom2); 
                  hi="Victoire de  la manche "+manche+" par "+nom2;
                    ajoutHistorique(hi);
                  manche=manche+1;
                score_2=1+score_2;//Augmentation du score du joueur 1
                }
                if(score_1>score_2){//test des score pour afficher qui mene au score
                   System.out.println("Le score est de "+score_1+"-"+score_2+" en faveur de "+nom1); 
                    hi="Le score est de "+score_1+"-"+score_2+" en faveur de "+nom1;
                    ajoutHistorique(hi);
                }else if(score_1<score_2){
                  System.out.println("Le score est de "+score_2+"-"+score_1+" en faveur de "+nom2);
                  hi="Le score est de "+score_1+"-"+score_2+" en faveur de "+nom2;
                    ajoutHistorique(hi);
                }else{
                   System.out.println("Le score est de "+score_1+"-"+score_2+". Egalite!!! "); 
                    hi="Le score est de "+score_1+"-"+score_2+". Egalite!!! ";
                    ajoutHistorique(hi);
                }
            nouvelleManche(nom1,nom2);
            return true;
            }
            }
        }
        //Verticalement
        for(int i=Menu.colones-1;i>=0;i--){
            for(int j=0;j<Menu.ligne-3;j++){
            if((p.getTableau()[j][i]==pion && p.getTableau()[j+1][i]==pion 
           && p.getTableau()[j+2][i]==pion&& p.getTableau()[j+3][i]==pion) //verifie ci 4 pions du meme genre sont alignes sur la meme colonne
            ){
                if(pion==" x "){
                 System.out.println("Victoire de  la manche "+manche+" par "+nom1);
                 hi="Victoire de  la manche "+manche+" par "+nom1;
                    ajoutHistorique(hi);
                 manche=manche+1;
                 score_1=1+score_1;
                }else if(pion==" o "){
                  System.out.println("Victoire de  la manche "+manche+" par "+nom2); 
                  hi="Victoire de  la manche "+manche+" par "+nom2;
                    ajoutHistorique(hi);
                  manche=manche+1;
                 score_2=1+score_2;
                }
                if(score_1>score_2){//test des scores pour afficher qui mène au score
                   System.out.println("Le score est de "+score_1+"-"+score_2+" en faveur de "+nom1); 
                    hi="Le score est de "+score_1+"-"+score_2+" en faveur de "+nom1;
                    ajoutHistorique(hi);
                }else if(score_1<score_2){
                  System.out.println("Le score est de "+score_2+"-"+score_1+" en faveur de "+nom2);
                  hi="Le score est de "+score_2+"-"+score_1+" en faveur de "+nom2;
                    ajoutHistorique(hi);
                }else{
                   System.out.println("Le score est de "+score_1+"-"+score_2+". Egalite!!! "); 
                    hi="Le score est de "+score_1+"-"+score_2+". Egalite!!! ";
                    ajoutHistorique(hi);
                }
            nouvelleManche(nom1,nom2);
            return true;
            }
            }
        }
         //Obliquement  bas vers le haut
                 for(int i=Menu.ligne-1;i>=Menu.ligne-3;i--){
            for(int j=0;j<Menu.colones-3;j++){
            if((p.getTableau()[i][j]==pion && p.getTableau()[i-1][j+1]==pion 
           && p.getTableau()[i-2][j+2]==pion&& p.getTableau()[i-3][j+3]==pion) //verifie ci 4 pions du meme genre sont alignes de facon oblique du bas vers le haut
            ){ 
                if(pion==" x "){
                 System.out.println("Victoire de  la manche "+manche+" par "+nom1);
                 hi="Victoire de  la manche "+manche+" par "+nom1;
                    ajoutHistorique(hi);
                 manche=manche+1;
                score_1=1+score_1;
                }else if(pion==" o "){
                  System.out.println("Victoire de  la manche "+manche+" par "+nom2); 
                  hi="Victoire de  la manche "+manche+" par "+nom2;
                    ajoutHistorique(hi);
                  manche=manche+1;
                score_2=1+score_2;
                }
               if(score_1>score_2){//test des score pour afficher qui mene au score
                   System.out.println("Le score est de "+score_1+"-"+score_2+" en faveur de "+nom1); 
                    hi="Le score est de "+score_1+"-"+score_2+" en faveur de "+nom1;
                    ajoutHistorique(hi);
                }else if(score_1<score_2){
                  System.out.println("Le score est de "+score_2+"-"+score_1+" en faveur de "+nom2);
                  hi="Le score est de "+score_2+"-"+score_1+" en faveur de "+nom2;
                    ajoutHistorique(hi);
                }else{
                   System.out.println("Le score est de "+score_1+"-"+score_2+". Egalite!!! "); 
                    hi="Le score est de "+score_1+"-"+score_2+". Egalite!!! ";
                    ajoutHistorique(hi);
                }
            nouvelleManche(nom1,nom2);
            return true;
            }
            }
        }
//Obliquement  haut vers le bas
            for(int i=Menu.ligne-4;i>=0;i--){
            for(int j=0;j<Menu.colones-3;j++){
            if((p.getTableau()[i][j]==pion && p.getTableau()[i+1][j+1]==pion 
           && p.getTableau()[i+2][j+2]==pion&& p.getTableau()[i+3][j+3]==pion) //verifie ci 4 pions du meme genre sont alignes de facon oblique du haut vers le bas 
            ){
            if(pion==" x "){
                 System.out.println("Victoire de  la manche "+manche+" par "+nom1);
                 hi="Victoire de  la manche "+manche+" par "+nom1;
                    ajoutHistorique(hi);
                  manche=manche+1;
                score_1=1+score_1;
                }else if(pion==" o "){
                  System.out.println("Victoire de  la manche "+manche+" par "+nom2);
                  hi="Victoire de  la manche "+manche+" par "+nom2;
                    ajoutHistorique(hi);
                   manche=manche+1;
                score_2=1+score_2; 
                }
                if(score_1>score_2){//test des score pour afficher qui mene au score
                   System.out.println("Le score est de "+score_1+"-"+score_2+" en faveur de "+nom1); 
                    hi="Le score est de "+score_1+"-"+score_2+" en faveur de "+nom1;
                    ajoutHistorique(hi);
                }else if(score_1<score_2){
                  System.out.println("Le score est de "+score_2+"-"+score_1+" en faveur de "+nom2);
                  hi="Le score est de "+score_2+"-"+score_1+" en faveur de "+nom2;
                    ajoutHistorique(hi);
                }else{
                   System.out.println("Le score est de "+score_1+"-"+score_2+". Egalite!!! "); 
                    hi="Le score est de "+score_1+"-"+score_2+". Egalite!!! ";
                    ajoutHistorique(hi);
                }
            nouvelleManche(nom1,nom2);
            return true;
            }
            }
        
        }
            // manche nulle
             num=0;//pour recuperer le nombre d'elements du tableau
            
            for(int i=0;i<=Menu.colones-1;i++){
              
                        if(p.getTableau()[0][i]!=" . "){
                   num=num+1;  
                   //System.out.println(num);
                   
               }
               if(num==Menu.colones){
                 manche=manche+1;    
                System.out.println("Partie nulle !!!");
                hi="Partie nulle !!!";
                    ajoutHistorique(hi);
                  if(score_1>score_2){//test des score pour afficher qui mene au score
                   System.out.println("Le score est de "+score_1+"-"+score_2+" en faveur de "+nom1); 
                    hi="Le score est de "+score_1+"-"+score_2+" en faveur de "+nom1;
                    ajoutHistorique(hi);
                }else if(score_1<score_2){
                  System.out.println("Le score est de "+score_2+"-"+score_1+" en faveur de "+nom2);
                  hi="Le score est de "+score_2+"-"+score_1+" en faveur de "+nom2;
                    ajoutHistorique(hi);
                }else{
                   System.out.println("Le score est de "+score_1+"-"+score_2+". Egalite!!! "); 
                    hi="Le score est de "+score_1+"-"+score_2+". Egalite!!! ";
                    ajoutHistorique(hi);
                }
                nouvelleManche(nom1, nom2);
                return true;
               }
                            }
                    return false;
    }
    public void nouvelleManche(String name1,String name2) throws IOException{
        int in;
if(score_1==Menu.nbrMan){//test pour voir si le score du joueur 1 est egal au nombre de manche gagnates
System.out.println("Victoire de la partie  par  "+name1+" sur un score de "+score_1+"-"+score_2);
hi="Victoire de la partie  par  "+name1+" sur un score de "+score_1+"-"+score_2;
ajoutHistorique(hi);
ajoutFichierHistorique();
nouvellePartie();
//m.menuDemarrage();
}else if(score_2==Menu.nbrMan){//test pour voir si le score du joueur 2 est egal au nombre de manche gagnates
System.out.println("Victoire de la partie par "+name2+" sur un score de "+score_2+"-"+score_1);
hi="Victoire de la partie  par  "+name2+" sur un score de "+score_2+"-"+score_1;
ajoutHistorique(hi);
ajoutFichierHistorique();
//m.menuDemarrage();
nouvellePartie();

        }else{
       System.out.println("*-------------------La manche "+manche+" commence-----------------------*");
       hi="*-------------------La manche "+manche+" commence-----------------------*";
       ajoutHistorique(hi);
        p.initialise_grille();
        if(manche%2==0){// test pour faire alterner les joueurs apres chaque manche
            compteur=2;
        }else{
            compteur=1; 
        }
       
         tourRolePlayer();
        }
    }
    public void commencerPartie() throws IOException{//Methode pour pouvoir commencer la partie   
       // m.lancerPartie();
        System.out.println("*-------------------La manche "+manche+" commence-----------------------*");
         hi="*-------------------La manche "+manche+" commence-----------------------*";
       ajoutHistorique(hi);
        tourRolePlayer();
    }
       public void lancer() throws IOException{//Methode pour pouvoir lancer la partie
           
           player_1.setNom(player_1.nomPlayer1());
           player_2.setNom(player_2.nomPlayer2());
           ia.getName();
         m.menuDemarrage();
       commencerPartie();
    }
 public void sortir() throws IOException{//Methode pour pouvoir sortir directement de la partie  
    out="";
    System.out.println("1- Voulez vous vraiment sortir de la partie ?");
    System.out.println("2- Annuler :)");
    System.out.println("----------Veullez entrer le numero correspondant---------");
    out1=sc.nextInt();
    if(out1==1){
      ajoutFichierHistorique();
      lancer();
        System.out.println("lancer");
        
    } else if(out1==2){
    tourRolePlayer();
    }else{
        System.out.println("Veuiller entrer un numero valide");
    }

 } 
       public void ajoutHistorique(String s){ 
           if(m.respond()==1){
           historique[0]=Humain.h1;
           historique[1]=Humain.h2;
           historique[n]=s;
           n=n+1;
           }else if(m.respond()==2){
           historique[0]=Humain.h1;
           if(Menu.numIa==1){
               historique[1]=IA.name1;
           }else if(Menu.numIa==2){
             historique[1]=IA.name2;  
           }
           
           historique[n]=s;
           n=n+1; 
               }else if(m.respond()==3){
           historique[0]=IA.name1;
           historique[1]=IA.name2;
           historique[n]=s;
           n=n+1; 
               }
           }
     public void ajoutFichierHistorique() throws IOException{//ajout de l'historique dans le fichier  log.txt
         String sep=null;
         sep=System.getProperty("file.separator");
         String ca=null;
         ca=System.getProperty("user.dir");
         FileWriter file=new FileWriter(ca+sep+"src"+sep+"log.txt");
         
        for(int i=0;i<300;i++){
             if(historique[i]!=null){
                 file.write(historique[i]);
                 file.write("\n");
                 //System.out.println("");
             }
         } 
        file.close();
     }
     //choix nom ia
     public void nomia(){
    if(Menu.numIa1==1){
          nomia1="Overhaul";
         }else if(Menu.numIa1==2){
           nomia1="Shigaraki";
         }else if(Menu.numIa1==3){
          nomia1="All_For_One";
         }
     if(Menu.numIa2==1){
          nomia2="Overhaul";
         }else if(Menu.numIa2==2){
           nomia2="Shigaraki";
         }else if(Menu.numIa2==3){
          nomia2="All_For_One";
         }
}
     
     //verifie si la  valeur saisie est un entier
     public static  boolean isNumeric(String s){
         try{
             Integer.parseInt(s);
             return true;
         }catch(NumberFormatException e){
             return false;
         }
     }
     
     
     public void nouvellePartie() throws IOException{
         System.out.println("*------------------------Voulez vous lancer une nouvelle Partie?------------------------*");
         System.out.println("*                                       1-Oui                                           *");
         System.out.println("*                                       2-Non                                           *");
         System.out.println("*------------------------Veuiller entrer le numero correspondant------------------------*");
         nouvp=sc.next();
         if(isNumeric(nouvp)){
             if(Integer.parseInt(nouvp)==1){
                 manche=1;
                 score_1=0;
                 score_2=0;
                 historique=null;
                 compteur=1;
               lancer();
             }else if(Integer.parseInt(nouvp)==2){
                 System.exit(0);
             }else{
                 System.err.println("Erreur saisie "+nouvp);
             }
         }else{
             System.err.println("Erreur saisie "+nouvp); 
         }
     }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        