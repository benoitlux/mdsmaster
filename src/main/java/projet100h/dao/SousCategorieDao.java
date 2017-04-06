package projet100h.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import projet100h.pojos.SousCategorie;




public class SousCategorieDao {
	
	public List<SousCategorie> listSousCategorie() {
		List<SousCategorie> SousCategories = new ArrayList<SousCategorie>();

		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM souscategorie")) {
			while (resultSet.next()) {
				SousCategories.add(new SousCategorie(resultSet.getInt("idsouscategorie"),resultSet.getString("nom"),resultSet.getInt("idcat")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}

		return SousCategories;
	}
	
	public void ajouterSousCategorie(SousCategorie SousCategories) {


        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO souscategorie(nom,idcat) VALUES(?, ?)");


            //Ajout des paramètres
            stmt.setString(1, SousCategories.getNom());
            stmt.setInt(2, SousCategories.getIdcat());
            
            
            stmt.executeUpdate();
            stmt.close();


            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void supprimerSousCategorie(Integer idsouscategorie) {

        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();

            // Utiliser la connexion
            PreparedStatement stmt = connection.prepareStatement(
                    "DELETE FROM souscategorie WHERE idsouscategorie=?");
            stmt.setInt(1, idsouscategorie);
            stmt.executeUpdate();
            stmt.close();

            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
