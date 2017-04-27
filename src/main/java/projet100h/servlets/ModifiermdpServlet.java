package projet100h.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projet100h.dao.ModifiermdpForm;
import projet100h.dao.SendTextMessage;
import projet100h.pojos.Utilisateur;
import projet100h.services.UtilisateurManager;

import java.io.IOException;



@WebServlet("/admin/modifiermdp")
public class ModifiermdpServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
   * Servlet modification du mot de passe
    */
    public static final String VUE = "/parametre.jsp";
    public static final String ATT_FORM = "form";
    public static final String ATT_RESULTAT = "resultat";


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Affichage de la page parametre */
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String resultat;


        String email = request.getParameter("utilisateur_mail");

        String mdp = request.getParameter("utilisateur_nouveau_mdp");

        System.out.println("email : " + email);
        System.out.println("mdp : " + mdp);


        /* Préparation de l'objet formulaire */
        ModifiermdpForm form = new ModifiermdpForm();

        /* Traitement de la requête et récupération du bean en résultant */
        Utilisateur utilisateur = null;
        try {
            utilisateur = form.modifierUtilisateur(request);
            System.out.println(form.modifierUtilisateur(request));
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();


        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        if (form.getErreurs().isEmpty()) {

            UtilisateurManager.getInstance().modifierMDP(email, mdp);
            SendTextMessage envoyeurDeMail = new SendTextMessage();


            try {
                String message = "Bonjour,\n\n"
                        + "Vous venez de modifier votre mot de passe.\n"
                        + "Voici votre nouveau mot de passe :  " + mdp + "\n\n"
                        + "Merci de le noter";
                envoyeurDeMail.envoyer_email("smtp.gmail.com", "465", "institutmomentdesoi@gmail.com",
                        email, "Modification mot de passe",
                        message);
            } catch (Exception e) {
                e.printStackTrace();
            }


            resultat = "Vous avez bien modifié votre mot de passe, vous avez reçu une confirmation par mail.";

        } else {
            resultat = "Échec de la modification.";


        }

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute(ATT_FORM, form);
        request.setAttribute(ATT_RESULTAT, resultat);



            /* Transmission de la paire d'objets request/response à notre JSP */
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);


    }
}



