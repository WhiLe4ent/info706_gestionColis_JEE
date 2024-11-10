# Rendu Projet Jakarta – Gestion de Colis

## Description

Cette application de suivi de colis, développée en Jakarta EE, permet à un utilisateur de créer et suivre des colis. J'ai opté pour la base de données intégrée H2 fournie par le serveur WildFly, afin de simplifier le déploiement.

### Fonctionnalités
1. **Création de colis** : Permet la création d’un nouveau colis avec des informations de base (ID, origine, destination, etc.).
2. **Suivi de colis** : Affiche les détails d'un colis et sa position actuelle. L'utilisateur entre l'ID du colis pour accéder à ces informations.
3. **Progression du colis** : Permet la mise à jour de la position d'un colis existant.
4. **Liste des colis** (en cours) : Endpoint pour afficher la liste de tous les colis (actuellement non fonctionnel).

### Endpoints
L'application comprend les endpoints suivants :
- `creerColis/` : pour créer un nouveau colis
- `suiviColis/` : pour afficher les informations d'un colis existant
- `progressionColis/` : pour modifier la position d'un colis
- `listeColis/` : pour afficher la liste des colis (non fonctionnel pour le moment)

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
- Le endpoint `listeColis/` n'est pas fonctionnel pour l'instant. J'ai quand même laissé pour le rendu même si ce n'était pas attendu pour voir si vous pourriez m'aider à le résoudre par curiosité.