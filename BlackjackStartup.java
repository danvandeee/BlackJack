package blackjack;

import java.util.ArrayList;
import java.util.Collections;
 //ook test voor github
//// Functionele doelstelling 
//maak een blackjack spel

//Technische Strategie
//fix de asen, als er boven de 21 punten zijn!
//elke new game shuffle

//Coderen




public class BlackjackStartup {

	String [] vormen = {"harten", "ruiten", "klaver", "schoppen"};
	String [] cijfersEnPlaatjes;
	int kaartNummer = 0;
	
	ArrayList<BlackjackCard> deKaarten= new ArrayList<BlackjackCard>();
	ArrayList<BlackjackCard> jeHand = new ArrayList<BlackjackCard>();
	int [] kaartenDeck = new int [52];
	int gepaktekaartnummer = 0;
	
	
	
	public void startUp () {
		kaartNummer = 0;                                        //wordt gebruikt voor het tellen van het aantal kaarten
		cijfersEnPlaatjes = new String [13];					//string array die alle mogelijkheden van cijfers en plaatjes
		int cijferTeller = 0;
		for (int i = 0;i < 9; i++) {
			cijfersEnPlaatjes[cijferTeller] = ((i+2) + "");		//doet het cijfer bij de juiste kaart
			cijferTeller++;										//elke loop 1 stap verder in de array
		}
		cijfersEnPlaatjes[9] = "boer";
		cijfersEnPlaatjes[10] = "koningin";
		cijfersEnPlaatjes[11] = "koning"; 
		cijfersEnPlaatjes[12] = "aas";
		
		
		
		for (String vorm: vormen) {  					//voor elke vorm worden 13 kaarten gemaakt
			int kaartnummerPerVorm = 0;
			for (String cijferofplaat : cijfersEnPlaatjes) {
				BlackjackCard kaartje = new BlackjackCard(vorm, cijferofplaat, kaartnummerPerVorm);
				deKaarten.add(kaartje);
				kaartNummer++;
				kaartnummerPerVorm++;
				System.out.println("kaart nummer " + kaartNummer + " is " + kaartje.getVorm() + kaartje.getGetalOfPlaat() + " en is waard " + kaartje.getPuntenWaard());
				
			} //end for each cijfersenplaatjes
			
			
			
		} //end for each vorm
		
		System.out.println(deKaarten.get(0).getGetalOfPlaat());
		
		
		shuffleCards();
	
		
		startPlaying();
		
		} //end startup
		
	public void startPlaying () {
		Boolean isPlaying = true;
		jeHand.clear();
		gepaktekaartnummer = 0;
		System.out.println("het spel is begonnen!");
		UserInput userinput = new UserInput();
		while (isPlaying) {
			
			String input = userinput.getInput();
			System.out.println(input);
			
			if (input.equals("k")) {  //kaart vragen
				isPlaying = getaCard();
				
			} else if (input.equals("p")) { //pass
				
			} else {   //stop met spelen
				
				isPlaying = false;
			} //end if en else statements
			
		} // end while isplayingit
		boolean wantToStop = false;
		while (!wantToStop) {
		System.out.println("wil je opnieuw spelen? y/n");
		String input = userinput.getInput();
		 if (input.equals("y")) {  //kaart vragen
			wantToStop = true;
			shuffleCards();
			startPlaying();
		} else if (input.equals("n")) {
			wantToStop = true;
			
		} //end else if
		 
		 else {
			
		} //end else
		} //end while loop (wantToStop)
		
	} //end startPlaying();
	
	private boolean getaCard() {
		int totalPoints = 0;
		System.out.println("hier heb je een kaart :)");
		deKaarten.get(gepaktekaartnummer).getGetalOfPlaat();
		jeHand.add(deKaarten.get(gepaktekaartnummer));
		
		System.out.println("in je hand heb je nu:");
		for (BlackjackCard kaarten : jeHand) {
			System.out.println(kaarten.getVorm() + kaarten.getGetalOfPlaat() + " deze is waard " + kaarten.getPuntenWaard());
			totalPoints += kaarten.getPuntenWaard();
		} //end for loop
		gepaktekaartnummer++;
		
		System.out.println("je hebt nu " + totalPoints + " punten!");
		
		  if (totalPoints == 21) {
			System.out.println("lekker dan, je hebt 21 en hebt deze ronde gewonnen!");	
			System.out.println("het spel word nu afgesloten");
			return false;
		} else if (totalPoints <22) {
				return true;
			}
		
		else {
			 for (BlackjackCard kaart : jeHand) {
				if (kaart.isAas == true) {
				kaart.setPuntenWaard(1);
				return true;
				}
			}
			
			System.out.println("oei je hebt er meer dan 21, je hebt verloren!");
			return false;
		}
		
		
	} //end getaCard
	
	public void shuffleCards () {
		

		//dit stuk shuffelt de kaarten
		
		Collections.shuffle(deKaarten);
		for (BlackjackCard kaart : deKaarten) {
			System.out.println(kaart.getVorm() + kaart.getGetalOfPlaat());
			
		} //end for loop
		
		
	}
		
		
		
	} //end class
	
	

