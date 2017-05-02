package projet100h.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;


import projet100h.dao.SendTextMessage;
import projet100h.pojos.Newsletter;


import projet100h.services.NewsletterService;






@WebServlet("/admin/newsletter")
public class NewsletterServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = -3032812618526895052L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
				
		List<Newsletter> listNews= NewsletterService.getInstance().listNewsletter();
		context.setVariable("newsletters", listNews);
		
		templateEngine.process("newsletter", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String mail = req.getParameter("mail");
				
		
		Newsletter newMail = new Newsletter(null, mail);
		NewsletterService.getInstance().ajouterNewsletter(newMail);
	        
	        
				
		
		
		
		String[] utilisateur_mail = req.getParameterValues("mails");
        System.out.println("recuperation :" + utilisateur_mail);
        
        
    /*    try {
            SendTextMessage envoyeurDeMail = new SendTextMessage();



           
            String message = "Bonjour,\n\n"
                    + "Vous venez de modifier votre mot de passe .\n"
                    + "Voici votre nouveau mot de passe :  "
                    + "Merci de le noter";
            envoyeurDeMail.envoyer_email("smtp.gmail.com", "465", "institutmomentdesoi@gmail.com",
                    utilisateur_mail, "Newsletter", message);


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
*/

         /* Redirection vers confirmation inscription ! */
        resp.setCharacterEncoding("UTF8");
        resp.sendRedirect("newsletter");

	
}
	}

