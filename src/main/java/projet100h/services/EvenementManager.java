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

}
