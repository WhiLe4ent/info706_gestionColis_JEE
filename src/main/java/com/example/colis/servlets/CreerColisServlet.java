package src.main.java.com.example.colis.servlets;

import src.main.java.com.example.colis.entities.Colis;
import src.main.java.com.example.colis.ejb.ColisService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/creerColis")
public class CreerColisServlet extends HttpServlet {

    @Inject
    private ColisService colisService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirection vers creerColis.jsp pour afficher le formulaire
        request.getRequestDispatcher("creerColis.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String origine = request.getParameter("origine");
        String destination = request.getParameter("destination");
        Double poids = Double.parseDouble(request.getParameter("poids"));
        Double valeur = Double.parseDouble(request.getParameter("valeur"));
    
        Colis colis = new Colis();
        colis.setId(id);
        colis.setOrigine(origine);
        colis.setDestination(destination);
        colis.setPoids(poids);
        colis.setValeur(valeur);
    
        // Récupération et configuration des informations de PositionColis
        double latitude = Double.parseDouble(request.getParameter("latitude"));
        double longitude = Double.parseDouble(request.getParameter("longitude"));
        String emplacement = request.getParameter("emplacement");
        String etat = request.getParameter("etat");
        LocalDateTime datePosition = LocalDateTime.now();
    
        // Initialisation de l'objet de position dans Colis
        colis.setLatitude(latitude);
        colis.setLongitude(longitude);
        colis.setEmplacement(emplacement);
        colis.setEtat(etat);
        colis.setDatePosition(datePosition);
    
    
        // Création du colis dans la base de données
        colisService.creerColis(colis);

        Colis colisResultat = colisService.obtenirColis(colis.getId());

        // Passer l'objet 'colis' à la page JSP via l'attribut de requête
        request.setAttribute("colis", colisResultat);
    
        // Rediriger vers la page de confirmation
        request.getRequestDispatcher("confirmation.jsp").forward(request, response);
    }
    
}
