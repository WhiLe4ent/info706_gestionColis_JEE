<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Liste des Colis</title>
</head>
<body>
    <h1>Liste des Colis</h1>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Origine</th>
                <th>Destination</th>
                <th>Poids</th>
                <th>Valeur</th>
                <th>Suivi</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="colis" items="${colisList}">
                <tr>
                    <td>${colis.id}</td>
                    <td>${colis.origine}</td>
                    <td>${colis.destination}</td>
                    <td>${colis.poids}</td>
                    <td>${colis.valeur}</td>
                    <td><a href="suiviColis?id=${colis.id}">Suivre</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <p><a href="suiviColis">Suivre un autre colis</a></p>
    <p><a href="progressionColis">Gérer la progression d'un colis</a></p>
    <p><a href="creerColis">Creer un autre colis</a></p>
    <p><a href="gestion_Colis">Retour à l'accueil</a></p>
</body>
</html>
