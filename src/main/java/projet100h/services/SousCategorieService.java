package projet100h.services;
import java.io.IOException;
import java.util.List;
import projet100h.dao.SousCategorieDao;
import projet100h.pojos.SousCategorie;


public class SousCategorieService {

private SousCategorieDao SousCategorieDao = new SousCategorieDao();
	
	
		
	private static class SousCategorieServiceHolder {
		private static SousCategorieService instance = new SousCategorieService();
	}
	
	public static SousCategorieService getInstance() {
		return SousCategorieServiceHolder.instance;
	}

	private SousCategorieService() {
	}
	
	

	 public List<SousCategorie> listSousCategorie() {
	        return SousCategorieDao.listSousCategorie();

	    }
	
	 public void ajouterSousCategorie(SousCategorie nouvelleSousCategorie) {
	        

	        SousCategorieDao.ajouterSousCategorie(nouvelleSousCategorie);
	    }
	 
	 public void supprimerSousCategorie(Integer idsouscategorie) {


	        SousCategorieDao.supprimerSousCategorie(idsouscategorie);
	    }
	 
	 public void updateSousCat(Integer idsouscategorie, String nom
				) throws IOException {
			SousCategorieDao.updateSousCat(idsouscategorie, nom);
		}
	
	
}
