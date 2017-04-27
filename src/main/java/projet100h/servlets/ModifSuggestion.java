package projet100h.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import projet100h.pojos.ImageS3;
import projet100h.pojos.Suggestion;
import projet100h.services.SuggestionService;




@WebServlet("/admin/ModifSuggestion")
@MultipartConfig
public class ModifSuggestion extends AbstractGenericServlet{

	private static final long serialVersionUID = -3032812618526895052L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		
		
		List<Suggestion> listSug= SuggestionService.getInstance().listSuggestions();
		context.setVariable("suggestions", listSug);
		
		
		
				
		templateEngine.process("ModifSuggestion", context, resp.getWriter());
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
			
		
				
		
		
		
		Integer Idsuggestion =Integer.parseInt(req.getParameter("Idsuggestion"));
		String titre = req.getParameter("text");
		String soustitre = req.getParameter("titre");
		String text = req.getParameter("soustitre");
		Part SuggestionImage = req.getPart("image");
		       
	        
				
	//	SuggestionService.getInstance().ajouterSuggestion(newSuggestion, req.getPart("image"));
				
		List <Suggestion> listSuggestion = SuggestionService.getInstance().listSuggestions();
		int taille = listSuggestion.size();	
		Suggestion lArticle = listSuggestion.get(taille-1);
				
		String id = lArticle.getIdsuggestion().toString();
		System.out.println("id : "+id);
		String chemin = "https://s3.eu-west-2.amazonaws.com/momentdesoi/suggestion-"+id;
		ImageS3.uploadImageToAWSS3(SuggestionImage, "suggestion-"+id);
		
	//	Suggestion pr = new Suggestion(lArticle.getIdsuggestion(), titre, soustitre, text, chemin);
		
		SuggestionService.getInstance().updateSuggestions(lArticle.getIdsuggestion(), titre, soustitre, text, chemin);
		
		
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("AccueilBack");
	
	}

	
}
