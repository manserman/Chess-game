Jeu d'Échecs en Java
Description: 
Ce projet consiste en la conception d'un jeu d'échecs pour deux utilisateurs. Il utilise Java Swing pour l'interface graphique, le multi-threading pour gérer les interactions en temps réel, et la sérialisation pour la sauvegarde et la restauration de l'état du jeu. Le jeu est construit sur une architecture MVC (Modèle-Vue-Contrôleur), garantissant une séparation claire entre la logique du jeu, l'affichage et la gestion des interactions utilisateur.

Fonctionnalités:
Jeu à 2 joueurs : Deux utilisateurs peuvent s'affronter en prenant des tours successifs.
Interface graphique : L'interface du jeu est réalisée avec Java Swing pour une expérience utilisateur interactive et visuelle.
Gestion en temps réel : Utilisation du multi-threading pour gérer les interactions des joueurs sans interruption.
Sauvegarde et restauration : Sérialisation de l'état du jeu pour permettre la sauvegarde et le chargement des parties.
Architecture MVC :
Modèle : Gestion de la logique métier, des règles d'échecs et de l'état du jeu.
Vue : Interface graphique créée avec Java Swing, affichant le plateau d'échecs et les pièces.
Contrôleur : Gère les interactions utilisateur, les entrées et les mises à jour entre la vue et le modèle.
Prérequis
Java 11 ou version ultérieure.
IDE tel que IntelliJ IDEA, Eclipse ou tout autre éditeur de texte compatible Java.
Installation
Clonez ce dépôt :

bash:
Copier le code
git clone https://github.com/username/chess-game.git
Naviguez dans le répertoire du projet :

bash:
Copier le code
cd chess-game
Compilez et exécutez le projet à l'aide de votre IDE préféré ou de la ligne de commande :

bash
Copier le code
javac -d bin src/*.java
java -cp bin Main
Structure du Projet
src/ : Contient les fichiers sources du projet.
model/ : Définit la logique métier du jeu d'échecs, y compris les règles de mouvement des pièces, la gestion des états et la sérialisation des données.
view/ : Composants de l'interface graphique réalisés avec Java Swing, permettant d'afficher le plateau et les interactions des joueurs.
controller/ : Assure la gestion des interactions utilisateur, met à jour la vue et le modèle, et gère les événements du jeu.
Utilisation
Au démarrage du programme, deux joueurs peuvent jouer en alternance.
Les mouvements des pièces sont validés selon les règles standards des échecs.
L'interface Swing permet de visualiser les mouvements et l'état du plateau de manière interactive.
Le jeu peut être sauvegardé et restauré grâce à la sérialisation.

Améliorations Futures
Optimisation de l'interface graphique pour une meilleure expérience utilisateur.
Ajout de la gestion des parties en ligne.
Intégration d'un système de replay pour revoir les parties sauvegardées.
