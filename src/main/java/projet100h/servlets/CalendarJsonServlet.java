package projet100h.servlets;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import projet100h.services.EvenementManager;
import projet100h.pojos.CalendarDTO;



@WebServlet("/calendrier")
public class CalendarJsonServlet extends HttpServlet{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
	
	
	List<CalendarDTO> evenements = EvenementManager.getInstance().listerEvenements();
    request.setAttribute("evenements", evenements);



RequestDispatcher view = request.getRequestDispatcher("/jsp/calendrier.jsp");
view.forward(request, response);
}

}