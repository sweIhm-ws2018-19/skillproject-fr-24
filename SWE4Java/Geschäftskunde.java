
public class Gesch�ftskunde extends Kunde {
	private String firmenname;
	private Adresse domizilAdresse;
	
	public Gesch�ftskunde(Konto konto, Adresse adresse) {
		super(konto);
		this.domizilAdresse = adresse;
	}
}
