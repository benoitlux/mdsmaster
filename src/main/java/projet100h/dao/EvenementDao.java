package projet100h.dao;

import java.util.List;


import projet100h.pojos.CalendarDTO;

public interface EvenementDao {
	 /* Liste les événements validés*/
    public List<CalendarDTO> listerEvenements();
    
    /*ajoute l'évenement à la bdd*/
    public void ajouterEvenement(CalendarDTO evenements);

	
}
