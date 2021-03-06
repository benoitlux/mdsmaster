package projet100h.servlets;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;


import projet100h.services.EvenementManager;
import projet100h.services.PrestationService;

import projet100h.pojos.CalendarDTO;
import projet100h.pojos.Prestation;


	
	@WebServlet("/ajouter")

	public class AjoutCalendrierServlet extends AbstractGenericServlet {
		
		private static final long serialVersionUID = 1L;
	   
		
		
		
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			TemplateEngine templateEngine = this.createTemplateEngine(req);
			
			WebContext context = new WebContext(req, resp, req.getServletContext());
			
			
			
			List<Prestation> listPrest= PrestationService.getInstance().listPrestation();
			context.setVariable("prestations", listPrest);
			
			templateEngine.process("formulaireCalendrier", context, resp.getWriter());
			
		}

	     /*
	    * Servlet pour ajouter un événement
	     */

	    

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	
	    	
	    	
	    	
	    	
	     request.setCharacterEncoding("UTF-8");
	    	

	        String evenement_nom = request.getParameter("evenement_nom");
	       
	        String evenement_description = request.getParameter("evenement_description");

	        String Sevenement_date_debut = request.getParameter("evenement_date_debut");
	        String Sevenement_heure_debut = request.getParameter("evenement_heure_debut");
	        String Sevenement_minute_debut = request.getParameter("evenement_minute_debut");
	        String evenement_heure_debut = Sevenement_heure_debut.concat(Sevenement_minute_debut);

	        String evenement_email = request.getParameter("evenement_email");
	        String duree = request.getParameter("dure");
	        String evenement_telephone = request.getParameter("evenement_telephone");
	        
	        

	        CalendarDTO nouvelEvenement = new CalendarDTO(null, evenement_nom, Sevenement_date_debut, evenement_heure_debut, evenement_description, evenement_email,duree, false, evenement_telephone);
	        EvenementManager.getInstance().ajouterEvenement(nouvelEvenement);
	        
	        

	        response.sendRedirect("calendrier");
	    }

	    

	}


