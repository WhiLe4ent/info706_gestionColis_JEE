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

/**
 * Servlet SuiviColis
 * 
 * Display Colis information from Entity Manager
 * 
 */
@WebServlet("/suiviColis")
public class SuiviColisServlet extends HttpServlet {

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
