<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Suivi du Colis</title>
</head>
<body>
    <h1>Suivi du Colis</h1>

    <!-- Affichage des informations du colis -->
    <h2>Détails du Colis :</h2>
    <p><strong>ID:</strong> ${colis.id}</p>
    <p><strong>Origine:</strong> ${colis.origine}</p>
    <p><strong>Destination:</strong> ${colis.destination}</p>
    <p><strong>Poids:</strong> ${colis.poids} kg</p>
    <p><strong>Valeur:</strong> ${colis.valeur} €</p>

    <!-- Affichage de la position actuelle -->
    <h3>Position actuelle :</h3>
    <p><strong>Latitude:</strong> ${colis.latitude}</p>
    <p><strong>Longitude:</strong> ${colis.longitude}</p>
    <p><strong>Emplacement:</strong> ${colis.emplacement}</p>
    <p><strong>État:</strong> ${colis.etat}</p>

    <h3>Modifier la Position et l'État :</h3>
    <form action="suiviColis" method="POST">
        <input type="hidden" name="id" value="${colis.id}" />

        <label for="latitude">Latitude:</label>
        <input type="text" id="latitude" name="latitude" value="${colis.latitude}" required /><br>

        <label for="longitude">Longitude:</label>
        <input type="text" id="longitude" name="longitude" value="${colis.longitude}" required /><br>

        <label for="emplacement">Emplacement:</label>
        <input type="text" id="emplacement" name="emplacement" value="${colis.emplacement}" required /><br>

        <label for="etat">État:</label>
        <select id="etat" name="etat">
            <option value="enregistrement" ${colis.etat == 'enregistrement' ? 'selected' : ''}>Enregistrement</option>
            <option value="en attente" ${colis.etat == 'en attente' ? 'selected' : ''}>En attente</option>
            <option value="en acheminement" ${colis.etat == 'en acheminement' ? 'selected' : ''}>En acheminement</option>
            <option value="bloqué" ${colis.etat == 'bloqué' ? 'selected' : ''}>Bloqué</option>
            <option value="livré" ${colis.etat == 'livré' ? 'selected' : ''}>Livré</option>
        </select><br>

        <button type="submit">Mettre à jour la position</button>
    </form>

    <p><a href="listeColis">Voir la Liste des Colis</a></p>
    <p><a href="suiviColis?id=${colis.id}">Rafraîchir le suivi</a></p>
    <p><a href="suiviColis">Suivre un autre colis</a></p>
    <p><a href="creerColis">Creer un autre colis</a></p>
    <p><a href="gestion_Colis">Retour à l'acceuil</a></p>


</body>
</html>