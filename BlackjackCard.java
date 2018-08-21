package blackjack;

public class BlackjackCard {

	//aanpassing voor testen van github
	
	private String vorm;
	private String getalOfPlaat;
	public int puntenWaard;
	public boolean isAas = false;
	
	
	public BlackjackCard (String vormpie, String getalofplaatcreate, int kaartnummerPerVorm) {
		vorm = vormpie;
		getalOfPlaat = getalofplaatcreate;
		
		if (kaartnummerPerVorm < 10) {
			puntenWaard = ((kaartnummerPerVorm+2));		//doet het cijfer bij de juiste kaart
												//elke loop 1 stap verder in de array
		} else if (kaartnummerPerVorm == 12) {
		   puntenWaard = 11;
		   isAas = true;
		} else {
			
			puntenWaard = 10;
		}
		
		
	}
	
	public String getVorm () {
		return vorm;
		
	}
	
	public String getGetalOfPlaat () {
		return getalOfPlaat;
		
	}
	
	
}
