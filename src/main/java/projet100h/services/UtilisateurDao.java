package projet100h.services;


import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import projet100h.dao.DataSourceProvider;
import projet100h.pojos.Utilisateur;
import projet100h.utils.MotDePasseUtils;


public class UtilisateurDao {


    /* Implémentation de la méthode définie dans l'interface UtilisateurDao */
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO utilisateur(utilisateur_mail, utilisateur_mdp, utilisateur_type) VALUES(?, ?, ?)");

            stmt.setString(1, utilisateur.getUtilisateur_mail());
            stmt.setString(2, utilisateur.getUtilisateur_mdp());
            stmt.setInt(3, utilisateur.getUtilisateur_type());

            stmt.executeUpdate();
            stmt.close();

            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Permet de lister les responsables Planification
     */
    public List<Utilisateur> listerPlanification() {
        List<Utilisateur> listePlanification = new ArrayList<Utilisateur>();
        try {
            // Créer une nouvelle connexion à la BDD
            Connection connection = DataSourceProvider.getDataSource().getConnection();

            // Utiliser la connexion
            Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM utilisateur WHERE utilisateur_type =2 ");
            while (results.next()) {

                listePlanification.add(new Utilisateur(
                                results.getInt("utilisateur_id"),
                                results.getString("utilisateur_mail"),
                                results.getString("utilisateur_mdp"),
                                results.getInt("utilisateur_type")
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
        return listePlanification;
    }

    /**
     * Permet de lister les responsables Planification
     */
    public List<Utilisateur> listerCommission() {
        System.out.println("UtilisateurDaoImpl listerCommission");
        List<Utilisateur> listeCommission = new ArrayList<Utilisateur>();
        try {
            // Créer une nouvelle connexion à la BDD
            Connection connection = DataSourceProvider.getDataSource().getConnection();

            // Utiliser la connexion
            Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM utilisateur WHERE utilisateur_type =1 ");
            while (results.next()) {

                listeCommission.add(new Utilisateur(
                                results.getInt("utilisateur_id"),
                                results.getString("utilisateur_mail"),
                                results.getString("utilisateur_mdp"),
                                results.getInt("utilisateur_type")
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
        return listeCommission;
    }


    /**
     * Permet de supprimer les droits 1 ou 2 d'un ancien utilisateur responsable
     */
    public void modifierDroit(String utilisateur_mail) {
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE  utilisateur SET utilisateur_type=0 WHERE utilisateur_mail=? ");

            stmt.setString(1, utilisateur_mail);


            stmt.executeUpdate();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Permet de modifier les droit d'un utilisateur pour devenir du type 2 : responsable planification
     */
    public void ajouterPlanification(String utilisateur_mail) {
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE  utilisateur SET utilisateur_type=2 WHERE utilisateur_mail=? ");

            stmt.setString(1, utilisateur_mail);


            stmt.executeUpdate();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de modifier les droit d'un utilisateur pour devenir du type 1 : responsable commission
     */
    public void ajouterCommission(String utilisateur_mail) {
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE  utilisateur SET utilisateur_type=1 WHERE utilisateur_mail=? ");

            stmt.setString(1, utilisateur_mail);


            stmt.executeUpdate();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de modifier le mot de passe d'un utilisateur
     */
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
