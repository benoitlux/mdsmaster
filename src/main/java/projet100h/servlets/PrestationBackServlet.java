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
import projet100h.pojos.Prestation;
import projet100h.pojos.SousCategorie;
import projet100h.services.CategorieService;
import projet100h.services.InformationsService;
import projet100h.services.PrestationService;
import projet100h.services.SousCategorieService;



@WebServlet("/admin/PrestationBack")

public class PrestationBackServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = -3032812618526895052L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		List<Prestation> listPrest= PrestationService.getInstance().listPrestation();
		context.setVariable("prestations", listPrest);
		
		context.setVariable("information", InformationsService.getInstance().getInformations(1));
		
		List<SousCategorie> listSousCat= SousCategorieService.getInstance().listSousCategorie();
		context.setVariable("souscat", listSousCat);
		
		List<Categorie> listCat= CategorieService.getInstance().listCategorie();
		context.setVariable("cat", listCat);
		
		templateEngine.process("prestation_Back", context, resp.getWriter());
	}

	
}
