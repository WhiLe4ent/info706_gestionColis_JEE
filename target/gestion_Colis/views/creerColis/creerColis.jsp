<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Créer un Colis</title>
    <link rel="stylesheet" href="css/creerColis.css">

</head>
<body>
    <div class="container">
        <h1>Enregistrer un Nouveau Colis</h1>
        <form action="creerColis" method="post">

            <c:if test="${not empty errorMessage}">
                <p class="error-message">${errorMessage}</p>
            </c:if>

            <div class="form-row">
                <label for="id">Id :</label>
                <input type="number" id="id" name="id" required>
            </div>
            
            <div class="form-row">
                <label for="origine">Origine :</label>
                <input type="text" id="origine" name="origine" required>
            </div>
            
            <div class="form-row">
                <label for="destination">Destination :</label>
                <input type="text" id="destination" name="destination" required>
            </div>
            
            <div class="form-row">
                <label for="poids">Poids (kg) :</label>
                <input type="number" step="0.1" id="poids" name="poids" required>
            </div>
            
            <div class="form-row">
                <label for="valeur">Valeur (€) :</label>
                <input type="number" step="0.01" id="valeur" name="valeur" required>
            </div>
            
            <div class="form-row">
                <label for="latitude">Latitude :</label>
                <input type="number" step="0.0001" id="latitude" name="latitude" required>
            </div>
            
            <div class="form-row">
                <label for="longitude">Longitude :</label>
                <input type="number" step="0.0001" id="longitude" name="longitude" required>
            </div>
            
            <div class="form-row">
                <label for="emplacement">Emplacement :</label>
                <input type="text" id="emplacement" name="emplacement" required>
            </div>
            
            <div class="form-row">
                <label for="etat">État :</label>
                <select id="etat" name="etat">
                    <option value="enregistrement" ${colis.etat == 'enregistrement' ? 'selected' : ''}>Enregistrement</option>
                    <option value="en attente" ${colis.etat == 'en attente' ? 'selected' : ''}>En attente</option>
                    <option value="en acheminement" ${colis.etat == 'en acheminement' ? 'selected' : ''}>En acheminement</option>
                    <option value="bloque" ${colis.etat == 'bloque' ? 'selected' : ''}>Bloque</option>
                    <option value="livre" ${colis.etat == 'livre' ? 'selected' : ''}>Livre</option>
                </select>
            </div>

            <button type="submit">Créer Colis</button>
        </form>

        <p><a href="/gestion_Colis">Retour à l'acceuil</a></p>
    </div>
</body>
</html>
