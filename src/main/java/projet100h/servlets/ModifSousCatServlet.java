package projet100h.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import projet100h.pojos.SousCategorie;

import projet100h.services.SousCategorieService;




@WebServlet("/admin/ModifSousCat")
public class ModifSousCatServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = -3032812618526895052L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
				
		List<SousCategorie> listSousCat= SousCategorieService.getInstance().listSousCategorie();
		context.setVariable("souscat", listSousCat);
		
		
		
		templateEngine.process("ModifSousCat", context, resp.getWriter());
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Integer IdSousCat = Integer.parseInt(request.getParameter("Idsouscat"));
		String nom = request.getParameter("nom");
			
		
				
		
		SousCategorieService.getInstance().updateSousCat(IdSousCat, nom);
		response.setCharacterEncoding("UTF8");
		response.sendRedirect("PrestationBack");
	}

	
}
