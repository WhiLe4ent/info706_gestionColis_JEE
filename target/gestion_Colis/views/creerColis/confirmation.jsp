<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Confirmation</title>
</head>
<body>
    <h1>Colis créé avec succès !</h1>
    <p>Votre colis a été enregistré dans le système.</p>

    <!-- Affichage des détails du colis -->
    <h2>Détails du Colis :</h2>
    <p><strong>Origine:</strong> ${colis.origine}</p>
    <p><strong>Destination:</strong> ${colis.destination}</p>
    <p><strong>Poids:</strong> ${colis.poids} kg</p>
    <p><strong>Valeur:</strong> ${colis.valeur} €</p>

    <h3>Position du Colis :</h3>
    <p><strong>Emplacement:</strong> ${colis.emplacement}</p>
    <p><strong>État:</strong> ${colis.etat}</p>
    <p><strong>Latitude:</strong> ${colis.latitude}</p>
    <p><strong>Longitude:</strong> ${colis.longitude}</p>
    <p><strong>Date de la position :</strong> ${colis.datePosition}</p>

    <a href="views/creerColis/creerColis.jsp">Créer un autre colis</a> 
    <p><a href="listeColis">Voir la Liste des Colis</a></p>
    <p><a href="suiviColis">Voir le suivi des colis</a></p>
    <p><a href="progressionColis">Gérer la progression d'un colis</a></p>
    <p><a href="/">Retour à l'acceuil</a></p>
</body>
</html>
