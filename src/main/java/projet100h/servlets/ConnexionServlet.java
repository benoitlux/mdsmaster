package projet100h.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projet100h.dao.ConnexionForm;
import projet100h.pojos.Utilisateur;
import projet100h.utils.MotDePasseUtils;

@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {

     /*
    * Servlet de connexion
     */

    public static final String ATT_USER = "utilisateur";
    public static final String ATT_FORM = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String ATT_TYPE = "sessionType";

    public static final String VUE = "/connexion.jsp";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
        
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        /* Préparation de l'objet formulaire */
        ConnexionForm form = new ConnexionForm();

        /* Traitement de la requête et récupération du bean en résultant */
        Utilisateur utilisateur = null;
        try {
            System.out.println(form.connecterUtilisateur(request));
            utilisateur = form.connecterUtilisateur(request);
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
            session.setAttribute(ATT_SESSION_USER, utilisateur);
            session.setAttribute(ATT_TYPE, utilisateur.getUtilisateur_type());




             /* Redirection vers calendrier ! */
            response.sendRedirect("admin/AccueilBack");

        } else {
            session.setAttribute(ATT_SESSION_USER, null);

            /* Stockage du formulaire et du bean dans l'objet request */
            request.setAttribute(ATT_FORM, form);
            request.setAttribute(ATT_USER, utilisateur);

            this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
        }


    }
}

