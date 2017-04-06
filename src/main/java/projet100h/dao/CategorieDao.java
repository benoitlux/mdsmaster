package projet100h.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projet100h.pojos.Categorie;
import projet100h.pojos.Prestation;




public class CategorieDao {
	
	public List<Categorie> listCategorie() {
		List<Categorie> Categories = new ArrayList<Categorie>();

		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM categorie")) {
			while (resultSet.next()) {
				Categories.add(new Categorie(resultSet.getInt("idcategorie"),resultSet.getString("nom")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}

		return Categories;
	}
	
	
	
	
	
	

}
