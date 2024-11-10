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

@WebServlet("/mettreAJourPosition")
public class MettreAJourPositionServlet extends HttpServlet {

    @Inject
    private ColisService colisService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long colisId = Long.parseLong(request.getParameter("colisId"));
        Double latitude = Double.parseDouble(request.getParameter("latitude"));
        Double longitude = Double.parseDouble(request.getParameter("longitude"));
        String emplacement = request.getParameter("emplacement");
        String etat = request.getParameter("etat");

        Colis position = new Colis();
        position.setLatitude(latitude);
        position.setLongitude(longitude);
        position.setEmplacement(emplacement);
        position.setEtat(etat);
        position.setDatePosition(LocalDateTime.now());

        // colisService.ajouterPosition(colisId, position);

        response.sendRedirect("suivi.jsp?colisId=" + colisId); // Redirige vers une page de suivi
    }
}
