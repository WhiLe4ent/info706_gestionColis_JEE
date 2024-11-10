<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>Confirmation</title>
        <link rel="stylesheet" href="css/confirmation.css">

    </head>
    <body>
        <div class="container">
            <h1>Colis créé avec succès !</h1>
            <p>Votre colis a été enregistré dans le système.</p>

            <h2>Détails du Colis :</h2>
            <ul>
                <li><strong>Origine:</strong> ${colis.origine}</li>
                <li><strong>Destination:</strong> ${colis.destination}</li>
                <li><strong>Poids:</strong> ${colis.poids} kg</li>
                <li><strong>Valeur:</strong> ${colis.valeur} €</li>
            </ul>

            <h3>Position du Colis :</h3>
            <ul>
                <li><strong>Emplacement:</strong> ${colis.emplacement}</li>
                <li><strong>État:</strong> ${colis.etat}</li>
                <li><strong>Latitude:</strong> ${colis.latitude}</li>
                <li><strong>Longitude:</strong> ${colis.longitude}</li>
                <li><strong>Date de la position :</strong> ${colis.datePosition}</li>
            </ul>

            <a href="creerColis">Créer un autre colis</a>
            <p><a href="suiviColis">Voir le suivi des colis</a></p>
            <p><a href="progressionColis">Gérer la progression d'un colis</a></p>
            <p><a href="listeColis">Voir la Liste des Colis</a></p>
            <p><a href="/gestion_Colis">Retour à l'acceuil</a></p>
        </div>
    </body>
</html>
