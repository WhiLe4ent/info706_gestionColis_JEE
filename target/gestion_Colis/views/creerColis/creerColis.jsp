<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Créer un Colis</title>
</head>
<body>
    <h1>Enregistrer un Nouveau Colis</h1>
    <form action="creerColis" method="post">
        <!-- ID du colis -->
        <label for="id">Id :</label>
        <input type="number" id="id" name="id" required><br><br>

        <!-- Origine -->
        <label for="origine">Origine :</label>
        <input type="text" id="origine" name="origine" required><br><br>

        <!-- Destination -->
        <label for="destination">Destination :</label>
        <input type="text" id="destination" name="destination" required><br><br>

        <!-- Poids -->
        <label for="poids">Poids (kg) :</label>
        <input type="number" step="0.1" id="poids" name="poids" required><br><br>

        <!-- Valeur -->
        <label for="valeur">Valeur (€) :</label>
        <input type="number" step="0.01" id="valeur" name="valeur" required><br><br>

        <!-- Latitude -->
        <label for="latitude">Latitude :</label>
        <input type="number" step="0.0001" id="latitude" name="latitude" required><br><br>

        <!-- Longitude -->
        <label for="longitude">Longitude :</label>
        <input type="number" step="0.0001" id="longitude" name="longitude" required><br><br>

        <!-- Emplacement -->
        <label for="emplacement">Emplacement :</label>
        <input type="text" id="emplacement" name="emplacement" required><br><br>

        <!-- État -->
        <label for="etat">État :</label>
        <select id="etat" name="etat">
            <option value="enregistrement" ${colis.etat == 'enregistrement' ? 'selected' : ''}>Enregistrement</option>
            <option value="en attente" ${colis.etat == 'en attente' ? 'selected' : ''}>En attente</option>
            <option value="en acheminement" ${colis.etat == 'en acheminement' ? 'selected' : ''}>En acheminement</option>
            <option value="bloqué" ${colis.etat == 'bloqué' ? 'selected' : ''}>Bloqué</option>
            <option value="livré" ${colis.etat == 'livré' ? 'selected' : ''}>Livré</option>
        </select><br><br>

        <!-- Bouton de soumission -->
        <button type="submit">Créer Colis</button>
    </form>
    <p><a href="/">Retour à l'acceuil</a></p>

</body>
</html>