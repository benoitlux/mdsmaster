package projet100h.servlets;


import projet100h.pojos.CalendarDTO;
import projet100h.services.EvenementManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/evenements")
public class ListeEvenementServlet extends HttpServlet {

    /**
     * Servlet qui liste les événements à valider
     */

    private static final long serialVersionUID = 8762892363953511538L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<CalendarDTO> evenements = EvenementManager.getInstance().listerEvenementsAValider();
        request.setAttribute("evenements", evenements);

        RequestDispatcher view = request.getRequestDispatcher("/jsp/validationRDV.jsp");
        view.forward(request, response);
    }
}