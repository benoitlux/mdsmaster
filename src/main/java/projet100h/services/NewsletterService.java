package projet100h.services;
import java.io.IOException;
import java.util.List;

import projet100h.dao.NewsletterDao;
import projet100h.pojos.Newsletter;



public class NewsletterService {
	
private NewsletterDao NewsletterDao = new NewsletterDao();
	
	
	
	
	private static class NewsletterServiceHolder {
		private static NewsletterService instance = new NewsletterService();
	}
	
	public static NewsletterService getInstance() {
		return NewsletterServiceHolder.instance;
	}

	private NewsletterService() {
	}
	
	

	public List<Newsletter> listNewsletter() {
		return NewsletterDao.listNewsletter();
	}
	
	
		
	public void updateNewsletter(Integer idMail, String mail
			) throws IOException {
		NewsletterDao.updateNewsletter(idMail, mail);
	}
	
	 public void ajouterNewsletter(Newsletter NewNews) {
	        

		 NewsletterDao.ajouterNewsletter(NewNews);
	    }
	
	 public void supprimerNewsletter(Integer idMail) {


		 NewsletterDao.supprimerNewsletter(idMail);
	    }

}
