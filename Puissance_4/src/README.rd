                                                 ***************************************
                                                 **                                   **
                                                 **            PUISSANCE_4            **
                                                 **                                   **     
                                                 ***************************************



  Puissance 4 est un jeu de plateforme dont le but est d’aligner 4 pions sur une grille de 6 lignes et 7 colonnes. Une partie de Puissance 4 se joue en plusieurs
 manches. Au cours de chaque manche, tour à tour, chaque joueur devra choisir une colonne pour y placer son pion (X ou O), ce dernier glissera jusqu’à la position 
libre la plus basse dans la grille laissant ainsi la main à son adversaire. Le gagnant de la manche sera celui ayant réussi à aligner au moins 4 de ses pions,
l’alignement doit être soit horizontal, soit vertical, soit diagonal. Dans le cas contraire, si toutes les cases de la grille sont occupées et que personne 
n’a réussi à aligner 4 pions la manche sera déclarée comme nulle. Dans les deux cas, une nouvelle manche sera lancée.Finalement, le joueur qui remporte la partie est
le premier à avoir remporté 3 manches. Il est à noter que c’est toujours le Joueur 1 qui débute dans la première manche, puis ensuite il faut alterner le joueur qui 
débute la manche.


1- Interface terminal

L'interface terminal est l'interface sur la quelle on pourra gerer les interactions avec les utilisateurs. Avant de commencer à jouer, votre programme doit lors de 
son lancement afficher un menu permettant au joueur d’indiquer comment seront incarnés les deux joueurs. Pour cela le choix pourra être humain ou ia.
 Pour chaque joueur, un nom devra être entré.

2- Grille

Une fois le jeu lancé, avant chaque coup, une grille devra s’afficher et le joueur en cours devra saisir la colonne où il souhaite jouer. Il sera possible pour 
le joueur à tout moment de quitter le programme en utilisant la commande sortir. Le jeu se termine aussi automatiquement quand un des deux
joueurs atteint 3 manches gagnées.

3- Gestionnaire de partie

Le rôle du gestionnaire sera de mémoriser l’état de la grille, de demander aux joueurs de jouer, de décider si la partie en cours est finie, et enfin de mémoriser
le score. Dans le cas d’une égalité (la grille totalement remplie mais personne n’a réussi à aligner ses pions), la partie sera déclarée nulle, et aucun joueur ne 
gagne de point. Le joueur qui débute la partie doit alterner, en commençant par le joueur 1.

4- Joueurs
* Humain 

Ce joueur est très simple : c’est un humain qui va saisir la colonne dans laquelle il faut jouer.

* IA

Ce joueur là dans un premier temps va choisir une colonne libre au hasard.

5- Historique de partie

l'historique de partie sera dans un fichier log.txt à la racine du dossier dans lequel on a lancé la partie. Ce log doit contenir toutes les informations relatives à 
la partie sous le format suivant. Il est à noter que le fichier de log doit être remis à zéro lors d’une nouvelle partie. En outre le score est affiché dans l’ordre 
des joueurs.
                          
6- Gestion des erreurs 
  
Quand une erreur survient, un message d’erreur doit être affiché et la saisie doit être effectuée à nouveau. 

7- Ensuite                  
                        
* Implémenter des ia supplémentaires elles seront identifiées par des noms après le
mot ia (ia:Overhaul, ia:Shigaraki, ia:All_For_One). Vous pourrez même implémenter des tests qui
permettent de faire jouer les ia les unes contre les autres pour voir qui est la
meilleure.
* Permettre d’avoir une grille de taille arbitraire (contrainte: lignes x colonnes doit
être pair et plus grand ou égal à 8, au moins quatre colonnes).
* Permettre de configurer le nombre de manche à gagner pour remporter la partie.
*N’oubliez pas d'expliquer dans le fichier README ce que vous avez implémenté.

Membre du Projet:
1-AKAZONG ASSANTELOCK LOIC TAREK(CHEF)
2-TIECHAG MOUSSOM GLENN GODERIC