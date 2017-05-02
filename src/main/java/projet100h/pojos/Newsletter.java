package projet100h.pojos;

public class Newsletter {
	
	private Integer id_mail;
	private String mail;
	
	
	public Newsletter(Integer id_mail, String mail) {
		super();
		this.id_mail = id_mail;
		this.mail = mail;
	}


	public Integer getId_mail() {
		return id_mail;
	}


	public void setId_mail(Integer id_mail) {
		this.id_mail = id_mail;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
	

}
