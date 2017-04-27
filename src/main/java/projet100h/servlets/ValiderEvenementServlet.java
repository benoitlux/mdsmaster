package projet100h.servlets;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet100h.dao.SendTextMessage;

import projet100h.services.EvenementManager;


import java.io.IOException;
import java.security.NoSuchAlgorithmException;




@WebServlet("/admin/valider")
public class ValiderEvenementServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	public static final String CHAMP_EMAIL = "utilisateur_mail";


     /*
    * Servlet de validation d'événement
     */

	

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {


       String Sevenement_id = request.getParameter("id");
       // System.out.println("ValiderEvenementServlet : String ID " + Sevenement_id);

        int evenement_id = Integer.parseInt(Sevenement_id);
        EvenementManager.getInstance().validerEvenement(evenement_id);
        request.getSession().removeAttribute("evenement_id");

       // System.out.println("ValiderEvenementServlet : Int ID " + evenement_id);

       resp.sendRedirect("evenements");
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        
        String utilisateur_mail = request.getParameter("utilisateur_mail");
        System.out.println("recuperation" + utilisateur_mail);



        


        if (utilisateur_mail != null && utilisateur_mail.trim().length() != 0) {
            try {
                SendTextMessage envoyeurDeMail = new SendTextMessage();


                String message = "Bonjour,\n\n"
                        + "Nous vous confirmons votre rendez-vous à l'institut moment de soi .\n";
              
                String sujet = "Confirmation rendez-vous";
                       
                envoyeurDeMail.envoyer_email("smtp.gmail.com", "465", "institutmomentdesoi@gmail.com",
                        utilisateur_mail,sujet, message);


            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}







}