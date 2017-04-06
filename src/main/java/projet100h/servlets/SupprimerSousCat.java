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





@WebServlet("/admin/SupprimerSousCategorie")
public class SupprimerSousCat extends AbstractGenericServlet{

	private static final long serialVersionUID = -3032812618526895052L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		
		
		List<SousCategorie> listSousCat= SousCategorieService.getInstance().listSousCategorie();
		context.setVariable("souscat", listSousCat);
		
		
		
		
		
		
		templateEngine.process("SupprimerSousCat", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Integer Idsouscat = Integer.parseInt(req.getParameter("Idsouscat"));
		
		
		
				
		
		SousCategorieService.getInstance().supprimerSousCategorie(Idsouscat);
		
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("PrestationBack");
	}

	
}
