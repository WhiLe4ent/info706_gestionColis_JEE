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

/**
 * Servlet CreerColis
 * 
 */
@WebServlet("/creerColis")
public class CreerColisServlet extends HttpServlet {

    @Inject
    private ColisService colisService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/creerColis/creerColis.jsp").forward(request, response);
    }

    /**
     * Add Colis to Enity Manager
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        if (colisService.getColis(id) != null) {
            request.setAttribute("errorMessage", "Un colis avec cet ID existe déjà.");
            request.getRequestDispatcher("views/creerColis/creerColis.jsp").forward(request, response);
            return;
        }
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
    
        double latitude = Double.parseDouble(request.getParameter("latitude"));
        double longitude = Double.parseDouble(request.getParameter("longitude"));
        String emplacement = request.getParameter("emplacement");
        String etat = request.getParameter("etat");
        LocalDateTime datePosition = LocalDateTime.now();
    
        colis.setLatitude(latitude);
        colis.setLongitude(longitude);
        colis.setEmplacement(emplacement);
        colis.setEtat(etat);
        colis.setDatePosition(datePosition);
    
        colisService.creerColis(colis);

        Colis colisResultat = colisService.getColis(colis.getId());

        request.setAttribute("colis", colisResultat);
        request.getRequestDispatcher("views/creerColis/confirmation.jsp").forward(request, response);
    }
    
}
