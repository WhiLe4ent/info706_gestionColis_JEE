<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Entrer l'ID du Colis</title>
</head>
<body>
    <h1>Progression d'un Colis</h1>
    <p>Veuillez entrer l'ID du colis que vous souhaitez suivre :</p>

    <!-- Formulaire pour entrer l'ID du colis -->
    <form action="progressionColis" method="GET">
        <label for="id">ID du colis :</label>
        <input type="text" id="id" name="id" required />
        <button type="submit">Progression</button>
    </form>

    <p><a href="/">Retour à l'accueil</a></p>
</body>
</html>