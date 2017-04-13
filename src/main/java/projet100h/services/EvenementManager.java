package projet100h.services;

import java.util.List;


import projet100h.dao.EvenementDao;
import projet100h.dao.EvenementDaoImpl;
import projet100h.pojos.CalendarDTO;

public class EvenementManager {
	

	    /*
	    * Lien entre Servlet et Dao Evenement
	     */

	    private static EvenementManager instance;

	    private static EvenementDao EvenementDao = new EvenementDaoImpl();

	    public static EvenementManager getInstance() {
	        if (instance == null) {
	            instance = new EvenementManager();
	        }
	        return instance;
	    }

	    private EvenementManager() {
	    }

	    public List<CalendarDTO> listerEvenements() {
	        return EvenementDao.listerEvenements();

	    }
	    
	    public void ajouterEvenement(CalendarDTO nouvelEvenement) {
	        // TODO Auto-generated method stub

	        EvenementDao.ajouterEvenement(nouvelEvenement);
	    }
	    
	    public List<CalendarDTO> listerEvenementsAValider() {
	        return EvenementDao.listerEvenementsAValider();

	    }


	    public void supprimerEvenement(Integer evenement_id) {


	        EvenementDao.supprimerEvenement(evenement_id);
	    }

	    public void validerEvenement(Integer evenement_id) {


	        EvenementDao.validerEvenement(evenement_id);
	    }
	    
	    public static CalendarDTO getEvenement(Integer evenement_id) {
	        return EvenementDao.getEvenement(evenement_id);
	    }

}
