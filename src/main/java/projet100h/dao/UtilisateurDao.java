package projet100h.dao;
import java.sql.*;
import projet100h.dao.DataSourceProvider;
import projet100h.pojos.Utilisateur;



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


}
