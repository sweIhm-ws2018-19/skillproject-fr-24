
public class Geschäftskunde extends Kunde {
	private String firmenname;
	private Adresse domizilAdresse;
	
	public Geschäftskunde(Konto konto, Adresse adresse) {
		super(konto);
		this.domizilAdresse = adresse;
	}
}
