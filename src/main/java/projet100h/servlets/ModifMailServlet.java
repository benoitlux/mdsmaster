package projet100h.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import projet100h.pojos.Newsletter;
import projet100h.pojos.Prestation;
import projet100h.pojos.SousCategorie;
import projet100h.services.NewsletterService;
import projet100h.services.PrestationService;
import projet100h.services.SousCategorieService;




@WebServlet("/admin/ModifMail")
public class ModifMailServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = -3032812618526895052L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		
		List<Newsletter> listNews= NewsletterService.getInstance().listNewsletter();
		context.setVariable("newsletters", listNews);
		
				
		
		templateEngine.process("ModifMail", context, resp.getWriter());
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Integer IdMail = Integer.parseInt(request.getParameter("IdMail"));
		String mail = request.getParameter("newmail");
		
		
		
				
		
		NewsletterService.getInstance().updateNewsletter(IdMail, mail);
		response.setCharacterEncoding("UTF8");
		response.sendRedirect("newsletter");
	}

	
}