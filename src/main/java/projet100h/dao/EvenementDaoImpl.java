package projet100h.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import projet100h.pojos.CalendarDTO;



public class EvenementDaoImpl implements EvenementDao{
	
	@Override
    public List<CalendarDTO> listerEvenements() {
        List<CalendarDTO> listeEvenements = new ArrayList<CalendarDTO>();
        try {
            // Créer une nouvelle connexion à la BDD
            Connection connection = DataSourceProvider.getDataSource().getConnection();

            // Utiliser la connexion
            Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM evenements ORDER BY evenement_date_debut");
            while (results.next()) {


                //Récupération des paramètres
                listeEvenements.add(new CalendarDTO(
                                results.getInt("evenement_id"),
                                results.getString("evenement_nom"),
                        
                                results.getString("evenement_date_debut"),
                                results.getString("evenement_heure_debut"),
                             
                                results.getString("evenement_description"),
                            
                                results.getString("evenement_couleur"),
                                results.getString("duree")

                        )
                );
            }
            //ferme la connexion
            stmt.close();

        } catch (

                SQLException e)

        {

            e.printStackTrace();
        }
        return listeEvenements;
    }

	 @Override
	    public void ajouterEvenement(CalendarDTO evenement) {


	        try {
	            Connection connection = DataSourceProvider.getDataSource().getConnection();
	            PreparedStatement stmt = connection.prepareStatement("INSERT INTO evenements(evenement_nom, evenement_date_debut, evenement_heure_debut, evenement_description, evenement_couleur,duree) VALUES(?,?, ?, ?, ?, ?)");


	            //Ajout des paramètres
	            stmt.setString(1, evenement.getEvenement_nom());
	     
	            stmt.setString(2, evenement.getEvenement_date_debut());
	            stmt.setString(3, evenement.getEvenement_heure_debut());
	      
	            stmt.setString(4, evenement.getEvenement_description());
	
	            stmt.setString(5, evenement.getEvenement_couleur());
	            stmt.setString(6, evenement.getDuree());
	            stmt.executeUpdate();
	            stmt.close();


	            // Fermer la connexion
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	

	 
	 
}
