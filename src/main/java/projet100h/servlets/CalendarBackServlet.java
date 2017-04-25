package projet100h.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet100h.pojos.CalendarDTO;
import projet100h.services.EvenementManager;

@WebServlet("/calendrierBack")
public class CalendarBackServlet extends HttpServlet{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
	
	
	List<CalendarDTO> evenements = EvenementManager.getInstance().listerTousEvenements();
    request.setAttribute("evenements", evenements);



RequestDispatcher view = request.getRequestDispatcher("/jsp/calendrierBack.jsp");
view.forward(request, response);
}

}
