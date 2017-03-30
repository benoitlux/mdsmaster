package projet100h.dao;




import javax.servlet.http.HttpServletRequest;

import projet100h.pojos.Utilisateur;
import projet100h.utils.MotDePasseUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * Cette class permet de connecter les utilisateurs
 */
public final class ConnexionForm {
    private static final String CHAMP_EMAIL = "email";
    private static final String CHAMP_PASS = "motdepasse";

    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }


    /**
     * Connecte l'utilisateur avec email et mdp du formulaire.
     */
    public Utilisateur connecterUtilisateur(HttpServletRequest request) throws Exception {
        /* Récupération des champs du formulaire */
        String email = getValeurChamp(request, CHAMP_EMAIL);
        String motDePasse = getValeurChamp(request, CHAMP_PASS);

        Utilisateur utilisateur = new Utilisateur(null, null, null, null);

        /* Validation du champ email. */
        try {
            System.out.println();
            validationEmail(email);
        } catch (Exception e) {
            setErreur(CHAMP_EMAIL, e.getMessage());
        }
        utilisateur.setUtilisateur_mail(email);

        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse(motDePasse, email);
        } catch (Exception e) {
            setErreur(CHAMP_PASS, e.getMessage());
        }
        utilisateur.setUtilisateur_mdp(motDePasse);

        /* Ajout du champ type. */
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();

            Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT utilisateur_type FROM utilisateur WHERE utilisateur_mail = '" + email + "'");
            while (results.next()) {
                Integer utilisateur_type = results.getInt("utilisateur_type");
                System.out.println("UtilisateurType : " + utilisateur_type);
                utilisateur.setUtilisateur_type(utilisateur_type);


            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        /* Initialisation du résultat global de la validation. */
        if (erreurs.isEmpty()) {
            resultat = "Succès de la connexion.";
        } else {
            resultat = "Échec de la connexion.";
        }


        return utilisateur;
    }

    /**
     * Valide l'adresse email saisie.
     */
    private void validationEmail(String email) throws Exception {
        if (email == null && !email.matches("^[a-z-]*\\.[a-z-]*@hei\\.fr$")) {
            throw new Exception("Merci de saisir une adresse mail de la forme prenom.nom@hei.fr");
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

    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validationMotDePasse(String motDePasse, String email) throws Exception {


        if (motDePasse != null) {
            if (motDePasse.length() < 3) {
                throw new Exception("Le mot de passe doit contenir au moins 3 caractères.");
            } else {
                try {
                    Connection connection = DataSourceProvider.getDataSource().getConnection();

                    Statement stmt = connection.createStatement();
                    ResultSet results = stmt.executeQuery("SELECT utilisateur_mdp FROM utilisateur WHERE utilisateur_mail = '" + email + "'");
                    results.next();
                    String utilisateur_mdp_cripte = results.getString("utilisateur_mdp");

                    if (!MotDePasseUtils.validerMotDePasse(motDePasse, utilisateur_mdp_cripte)) {
                        throw new Exception("Mot de passe incorect.");
                    }

                    stmt.close();
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new Exception("Echec de connexion à la base de données.");
                }


            }
        } else {
            throw new Exception("Merci de saisir votre mot de passe.");
        }
    }


    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur(String champ, String message) {
        erreurs.put(champ, message);
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
        String valeur = request.getParameter(nomChamp);
        if (valeur == null || valeur.trim().length() == 0) {
            return null;
        } else {
            return valeur;
        }
    }
}
