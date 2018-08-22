package blackjack;

public class BlackjackCard {
	
	private String vorm;
	private String getalOfPlaat;
	private int puntenWaard;
	public boolean isAas = false;
	
	
	public BlackjackCard (String vormpie, String getalofplaatcreate, int kaartnummerPerVorm) {
		vorm = vormpie;
		getalOfPlaat = getalofplaatcreate;
		
		if (kaartnummerPerVorm < 9) {
			puntenWaard = ((kaartnummerPerVorm+2));		//doet het cijfer bij de juiste kaart
												
		} else if (kaartnummerPerVorm == 12) {          //voor het geval als de kaart een aas is
		   puntenWaard = 11;
		   isAas = true;
		} else {  										//voor de andere plaatjes
			
			puntenWaard = 10;
		}
		
		
	}
	
	public String getVorm () {
		return vorm;
		
	}
	
	public String getGetalOfPlaat () {
		return getalOfPlaat;
		
	}
	
	public int getPuntenWaard () {
		return puntenWaard;
		
	}
	
	public void setPuntenWaard (int puntenWaard) {
		this.puntenWaard = puntenWaard;
	}
	
	
}
