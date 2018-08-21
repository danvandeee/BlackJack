package blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class BlackjackStartup {

	String [] vormen = {"harten", "ruiten", "klaver", "schoppen"};
	String [] cijfersEnPlaatjes;
	
	ArrayList<BlackjackCard> deKaarten= new ArrayList<BlackjackCard>();
	int [] kaartenDeck = new int [52];
	
	int kaartNummer = 0;
	
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
			
			for (String cijferofplaat : cijfersEnPlaatjes) {
				BlackjackCard kaartje = new BlackjackCard(vorm, cijferofplaat);
				deKaarten.add(kaartje);
				kaartNummer++;
				System.out.println("kaart nummer " + kaartNummer + " is " + kaartje.getVorm() + kaartje.getGetalOfPlaat());
				
			} //end for each cijfersenplaatjes
			
			
			
		} //end for each vorm
		
		System.out.println(deKaarten.get(0).getGetalOfPlaat());
		
		
		//dit stuk shuffelt de kaarten
		
		Collections.shuffle(deKaarten);
		for (BlackjackCard kaart : deKaarten) {
			System.out.println(kaart.getVorm() + kaart.getGetalOfPlaat());
			
		}
		
	
		
		startPlaying();
		
		} //end startup
		
	public void startPlaying () {
		Boolean isPlaying = true;
		int points = 0;
		System.out.println("het spel is begonnen!");
		UserInput userinput = new UserInput();
		while (isPlaying) {
			
			String input = userinput.getInput();
			System.out.println(input);
			
			if (input.equals("k")) {  //kaart vragen
				
				
			} else if (input.equals("p")) { //pass
				
			} else {   //stop met spelen
				
				isPlaying = false;
			}
			
			System.out.println("spel is gestopt");
			
			
		}
		
		
		
		
	}
	
	
	
		
		
		
	}
	
	

