package meeldetuletus;

public class Kylalised {
	
	String nimi;
	int vanus;
	String email;
	
	public Kylalised(String nimi, int vanus, String email) {
		this.nimi = nimi;
		this.vanus = vanus;
		this.email = email;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public int getVanus() {
		return vanus;
	}

	public void setVanus(int vanus) {
		this.vanus = vanus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Kylalised [nimi=" + nimi + ", vanus=" + vanus + ", email=" + email + "]";
	}
	
}
