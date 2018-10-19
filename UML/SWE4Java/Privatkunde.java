
public class Privatkunde extends Kunde {
	private String vorname;
	private String nachname;
	private Adresse postAdresse;
	
	public Privatkunde(Konto konto, Adresse adresse) {
		super(konto);
		this.postAdresse = adresse;
	}
}
