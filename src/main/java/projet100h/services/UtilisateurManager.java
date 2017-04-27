package projet100h.services;


import projet100h.dao.UtilisateurDao;
import projet100h.pojos.Utilisateur;


public class UtilisateurManager {

    /*
   * Lien entre Servlet et Dao Utilisateur
    */
    private static UtilisateurManager instance;

    private  UtilisateurDao UtilisateurDao = new UtilisateurDao();

    public static UtilisateurManager getInstance() {
        if (instance == null) {
            instance = new UtilisateurManager();
        }
        return instance;
    }

    

    public void mdpoublie(Utilisateur nouvelUtilisateur) {
        UtilisateurDao.mdpoublie(nouvelUtilisateur);
    }
    
    public void modifierMDP(String utilisateur_mail, String utilisateur_mdp) {
        try {
            UtilisateurDao.modifierMDP(utilisateur_mail, utilisateur_mdp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    


}
