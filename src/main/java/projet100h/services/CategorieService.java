package projet100h.services;
import java.util.List;
import projet100h.dao.CategorieDao;
import projet100h.pojos.Categorie;



public class CategorieService {

private CategorieDao CategorieDao = new CategorieDao();
	
	
		
	private static class CategorieServiceHolder {
		private static CategorieService instance = new CategorieService();
	}
	
	public static CategorieService getInstance() {
		return CategorieServiceHolder.instance;
	}

	private CategorieService() {
	}
	
	

	 public List<Categorie> listCategorie() {
	        return CategorieDao.listCategorie();

	    }
	
	
	
	
	
}
