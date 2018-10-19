import java.util.ArrayList;
import java.util.List;

public class Konto {
	private String bezeichnung;
	private List<Kunde> zeichnungsberechtigter;
	
	//nicht nötig - "garantiert" 1..*
	public Konto(Kunde zeichnungsberechtigter, String bezeichnung) {
		this.zeichnungsberechtigter = new ArrayList<>();
		this.zeichnungsberechtigter.add(zeichnungsberechtigter);
	}
	
	public GeldBetrag saldo() {
		return null;
	}
	
	public void einzahlen(GeldBetrag betrag) {
		
	}
	
	//nicht nötig - "garantiert" 1..*
	public void addZeichnungsberechtigter(Kunde kunde) {
		zeichnungsberechtigter.add(kunde);
	}
}
