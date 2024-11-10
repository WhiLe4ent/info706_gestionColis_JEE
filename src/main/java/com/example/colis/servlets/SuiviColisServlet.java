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
import java.util.List;

@WebServlet("/suiviColis")
public class SuiviColisServlet extends HttpServlet {

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
                    request.getRequestDispatcher("views/suiviColis/suiviColis.jsp").forward(request, response);
                } else {
                    response.sendRedirect("error.jsp"); 
                }
            } catch (NumberFormatException e) {
                response.sendRedirect("error.jsp"); 
            }
        } else {
            request.getRequestDispatcher("views/suiviColis/suiviEnterId.jsp").forward(request, response);
        }
    }

}
