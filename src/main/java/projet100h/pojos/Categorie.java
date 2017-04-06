package projet100h.pojos;

public class Categorie {
	
	private Integer idcategorie;
	private String nom;
	
	
	public Categorie(Integer idcategorie, String nom) {
		super();
		this.idcategorie = idcategorie;
		this.nom = nom;
	}


	public Integer getIdcategorie() {
		return idcategorie;
	}


	public void setIdcategorie(Integer idcategorie) {
		this.idcategorie = idcategorie;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
