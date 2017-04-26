package projet100h.pojos;

public class CalendarDTO {

	    /**
	     * Définition de l'objet JAVA Evenement
	     */

	    private Integer evenement_id;
	    private String evenement_nom;
	   
	    private String evenement_date_debut;
	    private String evenement_heure_debut;

	    private String evenement_description;
	    private String evenement_email;
	    private String duree;
	    private boolean evenement_valide;
	    private String evenement_telephone;
	    
	    public CalendarDTO(Integer evenement_id, String evenement_nom,
	                     String evenement_date_debut, String evenement_heure_debut,
	                     String evenement_description, String evenement_email, String duree, Boolean evenement_valide, String evenement_telephone) {
	        super();
	        this.evenement_id = evenement_id;
	        this.evenement_nom = evenement_nom;
	   
	        this.evenement_date_debut = evenement_date_debut;
	        this.evenement_heure_debut = evenement_heure_debut;

	        this.evenement_description = evenement_description;

	        this.evenement_email = evenement_email;
	        this.duree = duree;
	        this.evenement_valide = evenement_valide;
	        this.evenement_telephone = evenement_telephone;

	    }

	   

		/**
	     * Getter et Setter
	     */
	    
	    

	    public Integer getEvenement_id() {
	        return evenement_id;
	    }


	    public boolean isEvenement_valide() {
			return evenement_valide;
		}

		public void setEvenement_valide(boolean evenement_valide) {
			this.evenement_valide = evenement_valide;
		}

		public String getDuree() {
			return duree;
		}

		public void setDuree(String duree) {
			this.duree = duree;
		}

		public void setEvenement_id(Integer evenement_id) {
	        this.evenement_id = evenement_id;
	    }


	    public String getEvenement_nom() {
	        return evenement_nom;
	    }


	    public void setEvenement_nom(String evenement_nom) {
	        this.evenement_nom = evenement_nom;
	    }




	    public String getEvenement_date_debut() {
	        return evenement_date_debut;
	    }


	    public void setEvenement_date_debut(String evenement_date_debut) {
	        this.evenement_date_debut = evenement_date_debut;
	    }


	    public String getEvenement_heure_debut() {
	        return evenement_heure_debut;
	    }


	    public void setEvenement_heure_debut(String evenement_heure_debut) {
	        this.evenement_heure_debut = evenement_heure_debut;
	    }


	 


	    public String getEvenement_description() {
	        return evenement_description;
	    }


	    public void setEvenement_description(String evenement_description) {
	        this.evenement_description = evenement_description;
	    }



	    public String getEvenement_email() {
	        return evenement_email;
	    }


	    public void setEvenement_email(String evenement_email) {
	        this.evenement_email = evenement_email;
	    }
	    
	    
	    public String getEvenement_telephone() {
	        return evenement_telephone;
	    }


	    public void setEvenement_telephone(String evenement_telephone) {
	        this.evenement_telephone = evenement_telephone;
	    }

	}

