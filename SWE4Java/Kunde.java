import java.util.ArrayList;
import java.util.List;

public class Kunde {
	
	private List<Konto> konto; //1..*
	
	//nicht n�tig - "garantiert" 1..*
	public Kunde(Konto konto) {
		this.konto = new ArrayList<>();
		this.konto.add(konto);
	}
	
	//nicht n�tig - "garantiert" 1..*
	public void addZeichnungsberechtigter(Konto newAccount) {
		this.konto.add(newAccount);
	}
	
}
