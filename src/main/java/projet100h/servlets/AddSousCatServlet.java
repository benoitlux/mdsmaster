package projet100h.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import projet100h.pojos.Categorie;

import projet100h.pojos.SousCategorie;
import projet100h.services.CategorieService;

import projet100h.services.SousCategorieService;




@WebServlet("/admin/AddSousCat")
public class AddSousCatServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = -3032812618526895052L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		List<Categorie> listCat= CategorieService.getInstance().listCategorie();
		context.setVariable("cat", listCat);
		
		
		templateEngine.process("AddSousCat", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nom = req.getParameter("nom");
		Integer idcat = Integer.parseInt(req.getParameter("Idcat"));
		
		
		 SousCategorie nouvelleSousCategorie = new SousCategorie(null, nom, idcat);
		 SousCategorieService.getInstance().ajouterSousCategorie(nouvelleSousCategorie);
	        
	        
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("PrestationBack");
	}

	
}