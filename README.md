# Rendu Projet Jakarta – Gestion de Colis

## Auteur : Gravouil Achille

## Description

Cette application de suivi de colis, développée en Jakarta EE, permet à un utilisateur de créer et suivre des colis. J'ai opté pour la base de données intégrée H2 fournie par le serveur WildFly, afin de simplifier le déploiement.

### Fonctionnalités
1. **Création de colis** : Permet la création d’un nouveau colis avec des informations de base (ID, origine, destination, etc.).
2. **Suivi de colis** : Affiche les détails d'un colis et sa position actuelle. L'utilisateur entre l'ID du colis pour accéder à ces informations.
3. **Progression du colis** : Permet la mise à jour de la position d'un colis existant.
4. **Liste des colis** : Endpoint pour afficher la liste de tous les colis.

### Endpoints
L'application comprend les endpoints suivants :
- `creerColis/` : pour créer un nouveau colis
- `suiviColis/` : pour afficher les informations d'un colis existant
- `progressionColis/` : pour modifier la position d'un colis
- `listeColis/` : pour afficher la liste des colis 

## Prérequis

- Serveur d'application **WildFly**
- **Maven** pour la compilation du projet

## Instructions de Déploiement

1. **Compilation** (si nécessaire) :  
   Si le projet n'a pas encore été compilé, placez-vous à la racine du projet (./info706_gestioncolis) et exécutez la commande suivante :

   ```bash
   mvn clean install
    ```

Cela générera un fichier `gestion_Colis.war` dans le dossier `/target`, prêt à être déployé.

2. **Déploiement** :  
Déployez le fichier `gestion_Colis.war` sur votre serveur WildFly.

3. **Lancement** :  
Une fois déployée, l'application sera accessible à l'adresse suivante :  
[http://127.0.0.1:8080/gestion_Colis/](http://127.0.0.1:8080/gestion_Colis/)

## Remarques

- La base de données H2 est utilisée pour une gestion simplifiée de la persistance.
- Dans le endpoint `listeColis/` j'affiche la liste des colis dans le listeColis.jsp avec la balise <c:forEach>. Pour que ça fonctionne j'importe la librairie et je dois rajouter la dependency javax.servlet mais elle déclenche des warning dans les logs du serveurs wildfly. Je n'ai pas réussi à les enlever et garder l'affichage de la liste des colis...