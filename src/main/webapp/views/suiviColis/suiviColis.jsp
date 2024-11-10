<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Suivi du Colis</title>
    <link rel="stylesheet" href="suiviColis.css">

</head>
<body>
    <div class="container">
        <h1>Suivi du Colis</h1>

        <h2>Détails du Colis :</h2>
        <p><strong>ID:</strong> ${colis.id}</p>
        <p><strong>Origine:</strong> ${colis.origine}</p>
        <p><strong>Destination:</strong> ${colis.destination}</p>
        <p><strong>Poids:</strong> ${colis.poids} kg</p>
        <p><strong>Valeur:</strong> ${colis.valeur} €</p>

        <h3>Position actuelle :</h3>
        <p><strong>Latitude:</strong> ${colis.latitude}</p>
        <p><strong>Longitude:</strong> ${colis.longitude}</p>
        <p><strong>Emplacement:</strong> ${colis.emplacement}</p>
        <p><strong>État:</strong> ${colis.etat}</p>

        <p><a href="listeColis">Voir la Liste des Colis</a></p>
        <p><a href="suiviColis?id=${colis.id}">Rafraîchir le suivi</a></p>
        <p><a href="suiviColis">Suivre un autre colis</a></p>
        <p><a href="progressionColis">Gérer la progression d'un colis</a></p>
        <p><a href="creerColis">Créer un autre colis</a></p>
        <p><a href="/gestion_Colis">Retour à l'accueil</a></p>
    </div>
</body>
</html>
