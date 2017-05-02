package projet100h.pojos;

public class Newsletter {
	
	private Integer idmail;
	private String mail;
	
	
	public Newsletter(Integer idmail, String mail) {
		super();
		this.idmail = idmail;
		this.mail = mail;
	}


	public Integer getIdmail() {
		return idmail;
	}


	public void setId_mail(Integer idmail) {
		this.idmail = idmail;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
	

}
