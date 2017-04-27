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


/*
*Cette class permet de modifier le mot de passe des utilisateurs
*
 */
public final class ModifiermdpForm {
    public static final String CHAMP_ANCIEN = "utilisateur_ancien_mdp";
    public static final String CHAMP_PASS = "utilisateur_nouveau_mdp";
    public static final String CHAMP_CONF = "utilisateur_confirmation_mdp";

    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Utilisateur modifierUtilisateur(HttpServletRequest request) throws Exception {
        /* Récupération des champs du formulaire */
        String email = request.getParameter("utilisateur_mail");
        String utilisateur_ancien_mdp = getValeurChamp(request, CHAMP_ANCIEN);
        String utilisateur_nouveau_mdp = getValeurChamp(request, CHAMP_PASS);
        String utilisateur_confirmation_mdp = getValeurChamp(request, CHAMP_CONF);


        //création d'un utilisateur
        Utilisateur utilisateur = new Utilisateur(null, null, null, null);


        utilisateur.setUtilisateur_mail(email);


        /* Validation du champ mot de passe ancien. */
        try {
            validationMotDePasseAncien(utilisateur_ancien_mdp, email);
        } catch (Exception e) {
            setErreur(CHAMP_ANCIEN, e.getMessage());
        }

        /* Validation des champs mot de passe et confirmation de mot de passe. */
        try {
            validationMotsDePasse(email, utilisateur_nouveau_mdp, utilisateur_confirmation_mdp);
        } catch (Exception e) {
            erreurs.put(CHAMP_CONF, e.getMessage());
        }
        utilisateur.setUtilisateur_mdp(utilisateur_confirmation_mdp);




        /* Initialisation du résultat global de la validation. */
        if (erreurs.isEmpty()) {
            resultat = "Succès de la modification.";
            //validationBDD(utilisateur_nouveau_mdp, email);
        } else {
            resultat = "Échec de la modification.";
        }
        return utilisateur;


    }


    /**
     * Valide le mot de passe saisi (ancien).
     */
    private void validationMotDePasseAncien(String motDePasse, String email) throws Exception {


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
                    try {
                        if (!MotDePasseUtils.validerMotDePasse(motDePasse, utilisateur_mdp_cripte)) {
                            throw new Exception("Mot de passe incorect.");
                        }
                    } catch (Exception e) {
                        throw new Exception("Mot de passe incorrect.");
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


    /**
     * Valide les mots de passe saisis (deux nouveaux).
     */
    private void validationMotsDePasse(String utilisateur_mail, String utilisateur_nouveau_mdp, String utilisateur_confirmation_mdp) throws Exception {

        if (utilisateur_nouveau_mdp != null && utilisateur_nouveau_mdp.trim().length() != 0 && utilisateur_confirmation_mdp != null && utilisateur_confirmation_mdp.trim().length() != 0) {
            if (!utilisateur_nouveau_mdp.equals(utilisateur_confirmation_mdp)) {
                throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
            } else if (utilisateur_nouveau_mdp.trim().length() < 3) {
                throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
            }
        } else {
            throw new Exception("Merci de saisir et confirmer votre mot de passe.");
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
