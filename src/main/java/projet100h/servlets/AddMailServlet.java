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

import projet100h.services.NewsletterService;





@WebServlet("/admin/AddMail")
public class AddMailServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = -3032812618526895052L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		List<Newsletter> listNews= NewsletterService.getInstance().listNewsletter();
		context.setVariable("newsletters", listNews);
		
		
		templateEngine.process("AddMail", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String mail = req.getParameter("mail");
		
		
		Newsletter newMail = new Newsletter(null, mail);
		NewsletterService.getInstance().ajouterNewsletter(newMail);
	        
	        
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("newsletter");
	}

	
}
