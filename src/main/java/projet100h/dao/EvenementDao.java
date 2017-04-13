package projet100h.dao;

import java.util.List;


import projet100h.pojos.CalendarDTO;

public interface EvenementDao {
	 /* Liste les événements validés*/
    public List<CalendarDTO> listerEvenements();
    
    /*ajoute l'évenement à la bdd*/
    public void ajouterEvenement(CalendarDTO evenements);
    
    /*supprimer l'évenement par son ID*/
    public void supprimerEvenement(Integer evenement_id);

    /*valide l'évenement par son ID*/
    public void validerEvenement(Integer evenement_id);

    /*liste les événements à valider*/
    public List<CalendarDTO> listerEvenementsAValider();
    
    /*recupère les evenements par l'id*/
    public CalendarDTO getEvenement(Integer evenement_id);
    

	
}
