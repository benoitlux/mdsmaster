package projet100h.servlets;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet100h.dao.DataSourceProvider;
import projet100h.dao.SendTextMessage;
import projet100h.pojos.Utilisateur;
import projet100h.services.UtilisateurManager;
import projet100h.utils.MotDePasseUtils;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/mdpoublie")
public class MdpoublieServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	public static final String CHAMP_EMAIL = "utilisateur_mail";
    public static final String ATT_ERREURS = "erreurs";
    public static final String VUE = "/mdpoublie.jsp";


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        Map<String, String> erreurs = new HashMap<String, String>();


        String utilisateur_mail = request.getParameter("utilisateur_mail");
        System.out.println("recuperation" + utilisateur_mail);



        try {
            validationEmail(utilisateur_mail);

        } catch (Exception e) {
            e.printStackTrace();

            /* Gérer les erreurs de validation ici. */
            erreurs.put(CHAMP_EMAIL, e.getMessage());
            System.out.println("erreur : " + erreurs);

        }


        if (erreurs.isEmpty()) {
            try {
                SendTextMessage envoyeurDeMail = new SendTextMessage();


                String utilisateur_mdp = generate();

                String utilisateur_mdp_cripte = MotDePasseUtils.genererMotDePasse(utilisateur_mdp);
                System.out.println("cripté : " + utilisateur_mdp_cripte);
                Utilisateur nouvelUtilisateur = new Utilisateur(null, utilisateur_mail, utilisateur_mdp_cripte, 0);
                UtilisateurManager.getInstance().mdpoublie(nouvelUtilisateur);

                String message = "Bonjour,\n\n"
                        + "Vous venez de modifier votre mot de passe .\n"
                        + "Voici votre nouveau mot de passe :  " + utilisateur_mdp + "\n\n"
                        + "Merci de le noter";
                envoyeurDeMail.envoyer_email("smtp.gmail.com", "465", "institutmomentdesoi@gmail.com",
                        utilisateur_mail, "Mot de passe oublié",
                        message);


            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (InvalidKeySpecException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


             /* Redirection vers confirmation inscription ! */
            response.sendRedirect("connexion");
        } else {

            /* Stockage du résultat et des messages d'erreur dans l'objet request */
            request.setAttribute(ATT_ERREURS, erreurs);


            /* Transmission de la paire d'objets request/response à notre JSP */
            this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

        }

    }


    /**
     * Valide l'adresse mail saisie.
     */
    private void validationEmail(String email) throws Exception {
        if (email != null && email.trim().length() != 0) {
            if (!email.matches("^[a-z-]*\\.[a-z-]*@outlook\\.com$")) {
                throw new Exception("Merci de saisir une adresse mail.");
            } else {
                try {
                    Connection connection = DataSourceProvider.getDataSource().getConnection();

                    Statement stmt = connection.createStatement();
                    ResultSet results = stmt.executeQuery("SELECT COUNT(*) AS total FROM utilisateur WHERE utilisateur_mail = '" + email + "'");
                    results.next();

                    if (results.getInt(1) == 0) {
                        throw new Exception("Le compte n'existe pas");
                    }


                    stmt.close();
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new Exception("Echec de connexion à la base de données.");
                }
            }
        } else {
            throw new Exception("Merci de saisir une adresse mail.");
        }
    }


    public String generate() {
        String chars = "abcdefghijklmnopqrstuvwxyz1234567890"; // Tu supprimes les lettres dont tu ne veux pas
        String motdepass = "";
        for (int x = 0; x < 8; x++) {
            int i = (int) Math.floor(Math.random() * 32); // Si tu supprimes des lettres tu diminues ce nb
            motdepass += chars.charAt(i);
        }
        System.out.println(motdepass);
        return motdepass;

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doGet(request, response);

        RequestDispatcher view = request.getRequestDispatcher("/mdpoublie.jsp");
        view.forward(request, response);
    }
}
