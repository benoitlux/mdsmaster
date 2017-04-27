package projet100h.dao;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;
import projet100h.dao.DataSourceProvider;
import projet100h.pojos.Utilisateur;
import projet100h.utils.MotDePasseUtils;



public class UtilisateurDao {


   
    /**
     * Permet de modifier le mot de passe d'un utilisateur si il a oublié le sien
     */
    public void mdpoublie(Utilisateur utilisateur) {
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE utilisateur SET utilisateur_mdp=? WHERE utilisateur_mail =?");

            stmt.setString(1, utilisateur.getUtilisateur_mdp());
            stmt.setString(2, utilisateur.getUtilisateur_mail());


            stmt.executeUpdate();
            stmt.close();


            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

   public void modifierMDP(String utilisateur_mail, String utilisateur_mdp) {


       try

       {
           String utilisateur_mdp_cripte = MotDePasseUtils.genererMotDePasse(utilisateur_mdp);

           Connection connection = DataSourceProvider.getDataSource().getConnection();
           PreparedStatement stmt = connection.prepareStatement("UPDATE  utilisateur SET utilisateur_mdp=? WHERE utilisateur_mail=?");

           stmt.setString(1, utilisateur_mdp_cripte);
           stmt.setString(2, utilisateur_mail);

           stmt.executeUpdate();
           stmt.close();
           connection.close();
       } catch (
               SQLException e
               )

       {
           e.printStackTrace();
       } catch (InvalidKeySpecException e) {
           e.printStackTrace();
       } catch (NoSuchAlgorithmException e) {
           e.printStackTrace();
       }

   }


}
