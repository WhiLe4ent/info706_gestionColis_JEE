<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- <%@ taglib uri="http://jakarta.apache.org/taglibs/standard/core" prefix="c" %> --%>
<%@ page import="java.util.List" %>
<%@ page import="src.main.java.com.example.colis.entities.Colis" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Liste des Colis</title>
    <link rel="stylesheet" href="css/listeColis.css">
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
            <%-- <c:forEach var="colis" items="${colisList}"> Fonctionne pas, problème de lib ? 
                <tr>
                    <td>${colis.id}</td>
                    <td>${colis.origine}</td>
                    <td>${colis.destination}</td>
                    <td>${colis.poids}</td>
                    <td>${colis.valeur}</td>
                    <td><a href="suiviColis?id=${colis.id}">Suivre</a></td>
                </tr>
            </c:forEach> --%>

            <%
                List<Colis> colisList = (List<Colis>) request.getAttribute("colisList");
                for (Colis colis : colisList) {
            %>
                <tr>
                    <td><%= colis.getId() %></td>
                    <td><%= colis.getOrigine() %></td>
                    <td><%= colis.getDestination() %></td>
                    <td><%= colis.getPoids() %></td>
                    <td><%= colis.getValeur() %></td>
                    <td><a href="suiviColis?id=<%= colis.getId() %>">Suivre</a></td>
                </tr>
            <%
                }
            %>
    </table>

    <p><a href="suiviColis">Suivre un autre colis</a></p>
    <p><a href="progressionColis">Gérer la progression d'un colis</a></p>
    <p><a href="creerColis">Creer un autre colis</a></p>
    <p><a href="/gestion_Colis">Retour à l'accueil</a></p>
</body>
</html>
