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
 * Servlet Progression Colis
 * 
 */
@WebServlet("/progressionColis")
public class ProgressionColisServlet extends HttpServlet {

    @Inject
    private ColisService colisService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        
        if (idParam != null && !idParam.isEmpty()) {
            try {
                Long colisId = Long.parseLong(idParam);

                Colis colis = colisService.getColis(colisId);

                if (colis != null) {
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

    /**
     * Allow the client to change the position information of the colis
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long colisId = Long.parseLong(request.getParameter("id"));
        Colis colis = colisService.getColis(colisId);

        if (colis != null) {
            double latitude = Double.parseDouble(request.getParameter("latitude"));
            double longitude = Double.parseDouble(request.getParameter("longitude"));
            String emplacement = request.getParameter("emplacement");
            String etat = request.getParameter("etat");

            colis.setLatitude(latitude);
            colis.setLongitude(longitude);
            colis.setEmplacement(emplacement);
            colis.setEtat(etat);

            colisService.mettreAJourColis(colis);

            request.setAttribute("colis", colis);
            request.getRequestDispatcher("views/progressionColis/progressionColis.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
