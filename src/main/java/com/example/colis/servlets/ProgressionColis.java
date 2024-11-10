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

@WebServlet("/progressionColis")
public class ProgressionColis extends HttpServlet {

    @Inject
    private ColisService colisService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer l'ID du colis depuis l'URL
        String idParam = request.getParameter("id");
        
        if (idParam != null && !idParam.isEmpty()) {
            try {
                Long colisId = Long.parseLong(idParam);

                // Récupérer le colis depuis la base de données
                Colis colis = colisService.obtenirColis(colisId);

                if (colis != null) {
                    // Passer le colis à la page JSP pour affichage
                    request.setAttribute("colis", colis);
                    request.getRequestDispatcher("views/progressionColis/progressionColis.jsp").forward(request, response);
                } else {
                    response.sendRedirect("error.jsp"); 
                }
            } catch (NumberFormatException e) {
                response.sendRedirect("error.jsp"); 
            }
        } else {
            request.getRequestDispatcher("views/progressionColis/progressionEnterId.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Traitement de la soumission du formulaire pour mettre à jour la position et l'état du colis
        Long colisId = Long.parseLong(request.getParameter("id"));
        Colis colis = colisService.obtenirColis(colisId);

        if (colis != null) {
            // Récupérer les nouvelles coordonnées et l'état de la position
            double latitude = Double.parseDouble(request.getParameter("latitude"));
            double longitude = Double.parseDouble(request.getParameter("longitude"));
            String emplacement = request.getParameter("emplacement");
            String etat = request.getParameter("etat");

            // Mettre à jour la position et l'état du colis
            colis.setLatitude(latitude);
            colis.setLongitude(longitude);
            colis.setEmplacement(emplacement);
            colis.setEtat(etat);

            // Enregistrer les modifications
            colisService.mettreAJourColis(colis);

            // Rediriger vers la page de suivi avec les informations mises à jour
            request.setAttribute("colis", colis);
            request.getRequestDispatcher("views/progressionColis/progressionColis.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
