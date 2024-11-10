package src.main.java.com.example.colis.servlets;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import src.main.java.com.example.colis.ejb.ColisService;
import src.main.java.com.example.colis.entities.Colis;

import java.io.IOException;
import java.util.List;

/**
 * Servlet Liste Colis
 * 
 * Dispatch the liste of the colis in the Entity Manager
 * 
 */
@WebServlet("/listeColis")
public class ListeColisServlet extends HttpServlet {

    @Inject
    private ColisService colisService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Colis> colisList = colisService.listerTousLesColis();
        request.setAttribute("colisList", colisList);
        request.getRequestDispatcher("views/listeColis/listeColis.jsp").forward(request, response);
    }
}

