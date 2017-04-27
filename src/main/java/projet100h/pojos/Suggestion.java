package projet100h.pojos;

public class Suggestion {
	
	private Integer idsuggestion;
	private String text;
	private String titre;
	private String soustitre;
	private String image;
	
	
	
		public Suggestion(Integer idsuggestion, String text, String titre, String soustitre, String image) {
		super();
		this.idsuggestion = idsuggestion;
		this.text = text;
		this.titre = titre;
		this.soustitre = soustitre;
		this.image = image;
	}
		
		
		public String getImage() {
			return image;
		}


		public void setImage(String image) {
			this.image = image;
		}



	public Integer getIdsuggestion() {
		return idsuggestion;
	}
	public void setIdsuggestion(Integer idsuggestion) {
		this.idsuggestion = idsuggestion;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getSoustitre() {
		return soustitre;
	}
	public void setSoustitre(String soustitre) {
		this.soustitre = soustitre;
	}
	
	
	

}
