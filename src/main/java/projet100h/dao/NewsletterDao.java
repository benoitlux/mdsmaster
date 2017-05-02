package projet100h.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projet100h.pojos.Newsletter;




public class NewsletterDao {
	
	public List<Newsletter> listNewsletter() {
		List<Newsletter> Newsletter = new ArrayList<Newsletter>();

		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM newsletter ")) {
			while (resultSet.next()) {
				Newsletter.add(new Newsletter(resultSet.getInt("idMail"),resultSet.getString("mail")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}

		return Newsletter;
	}
	

	
	public void updateNewsletter(Integer idMail, String mail			
			) {
		try(Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE newsletter SET mail='"+mail+"' WHERE idMail= '"+idMail+"' ")){
		statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	public void ajouterNewsletter(Newsletter Newsletters) {


        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO newsletter(mail) VALUES(?)");


            //Ajout des paramètres
            stmt.setString(1, Newsletters.getMail());
            
            
            stmt.executeUpdate();
            stmt.close();


            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void supprimerNewsletter(Integer idMail) {

        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();

            // Utiliser la connexion
            PreparedStatement stmt = connection.prepareStatement(
                    "DELETE FROM newsletter WHERE idMail=?");
            stmt.setInt(1, idMail);
            stmt.executeUpdate();
            stmt.close();

            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}