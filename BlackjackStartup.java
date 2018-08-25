package blackjack;

import java.util.ArrayList;
import java.util.Collections;
 //ook test voor github
//// Functionele doelstelling 
//maak een blackjack spel

//Technische Strategie  KIJK MARA~!!!


//Coderen

public class BlackjackStartup {

	String [] vormen = {"harten", "ruiten", "klaver", "schoppen"};  //wat ik mij afvraag is of het beter is om dit als local variable (in startup) te nemen, ipv instance variable
	String [] cijfersEnPlaatjes;
	
	ArrayList<BlackjackCard> deKaarten= new ArrayList<BlackjackCard>();
	ArrayList<BlackjackCard> jeHand = new ArrayList<BlackjackCard>();
	
	int gepaktekaartnummer = 0;
	int totalPoints = 0;
	
	
	
	public void startUp () {
		int kaartNummer = 0;                                        //wordt gebruikt voor het tellen van het aantal kaarten
		cijfersEnPlaatjes = new String [13];					//string array die alle mogelijkheden van cijfers en plaatjes
		int cijferTeller = 0;
		for (int i = 0;i < 9; i++) {
			cijfersEnPlaatjes[cijferTeller] = ((i+2) + "");		//doet het cijfer bij de juiste kaart
			cijferTeller++;										//elke loop 1 stap verder in de array
		}  //end for loop
		cijfersEnPlaatjes[9] = "boer";
		cijfersEnPlaatjes[10] = "koningin";
		cijfersEnPlaatjes[11] = "koning"; 
		cijfersEnPlaatjes[12] = "aas";
		
		
		
		for (String vorm: vormen) {  					//voor elke vorm worden 13 kaarten gemaakt
			int kaartnummerPerVorm = 0;					//word meegestuurd als argument zodat de kaart weet hoeveel punten hij zou moeten hebben
			for (String cijferofplaat : cijfersEnPlaatjes) { //voor elke cijfer/plaat word een kaart gecreërd
				BlackjackCard kaartje = new BlackjackCard(vorm, cijferofplaat, kaartnummerPerVorm);
				deKaarten.add(kaartje);						//elke gemaakte kaart word aan het decktoegevoegd
				kaartNummer++;
				kaartnummerPerVorm++;
				System.out.println("kaart nummer " + kaartNummer + " is " + kaartje.getVorm() + kaartje.getGetalOfPlaat() + " en is waard " + kaartje.getPuntenWaard());
				
			} //end for each cijfersenplaatjes
			
		} //end for each vorm
			
		shuffleCards();
	
		startPlaying();
		
		} //end startup
		
	public void startPlaying () {
		Boolean isPlaying = true;			//boolean om te kijken of je nog speeld (voor while loop)
		jeHand.clear();						//aan het begin word altijd je hand schoongemaakt
		gepaktekaartnummer = 0;
		System.out.println("het spel is begonnen!");
		UserInput userinput = new UserInput();  //deze class regelt de user input
		getaCard();								//eerste 2 kaaten die je altijd krijgt aan het begin
		getaCard();
		
		while (isPlaying) {						//als het spel nog bezig is, word deze loop elke keer opnieuw gedaan
			System.out.println("typ 'k' voor nieuwe kaart, 'q' om te stoppen en 'p' om te passen");
			String input = userinput.getInput(); //user input word nu gevraagd
			System.out.println(input);			
			try {
			if (input.equals("k")) {  				//kaart vragen
				isPlaying = getaCard();
				
			} else if (input.equals("p")) { 		//pass
				
			} else if (input.equals("q")) {   		//stop met spelen
				
				isPlaying = false;					//bij het stoppen word de while loop ook gestopt
			} //end if en else statements
			
		} catch (NullPointerException ex) {			//zorgt ervoor dat de exception gehandeld word bij een null input
			System.out.println("geen geldige input!");
			continue;
		} //end try and catch
			
			
		} // end while isplaying
		boolean wantToStop = false;      //dit block checkt of je opnieuw will spelen
		while (!wantToStop) {
		System.out.println("wil je opnieuw spelen? y/n");
		String input = userinput.getInput();
		 if (input.equals("y")) {  	//kaart vragen
			wantToStop = true;
			resetAasPunten();      	//nodig zodat de asen weer 11 punten zijn
			shuffleCards();			//schud de kaarten voor hergebruik
			startPlaying();			//start met opnieuw spelen   //is dit een memory leak? omdat de oude startPlaying nog niet af is?
		} else if (input.equals("n")) {
			wantToStop = true;
			
		} //end else if
		 
		 else {
			
		} //end else
		} //end while loop (wantToStop)
		
	} //end startPlaying();
	
	private boolean getaCard() {			//zorgt ervoor dat een kaart van de stapel gepakt kan worden
		totalPoints = 0;
		System.out.println("hier heb je een kaart :)");
		deKaarten.get(gepaktekaartnummer).getGetalOfPlaat();
		jeHand.add(deKaarten.get(gepaktekaartnummer));
		
		System.out.println("in je hand heb je nu:");
		for (BlackjackCard kaarten : jeHand) {				//kijkt naar alle kaarten in je hand en telt de totaal punten
			System.out.println(kaarten.getVorm() + kaarten.getGetalOfPlaat() + " deze is waard " + kaarten.getPuntenWaard());
			totalPoints += kaarten.getPuntenWaard();
		} //end for loop
		gepaktekaartnummer++;
		
		if (totalPoints > 21) {   					//eerste check voor meer dan 21 punten, deze test word gedaan om te kijken of er nog asen zijn die het kunnen verlagen
			for (BlackjackCard kaart : jeHand) {
				if (kaart.isAas == true && kaart.getPuntenWaard() != 1) { //als er meer dan 21 punten zijn, word de aas naar 1 punt veranderd
				kaart.setPuntenWaard(1);
				break;
				} //end if
				
			} //end for loop
			
			recountTotalPoints();				
		} //end if total points >21
		
		System.out.println("je hebt nu " + totalPoints + " punten!");
		
		  if (totalPoints == 21) {
			System.out.println("lekker dan, je hebt 21 en hebt deze ronde gewonnen!");	
			System.out.println("het spel word nu afgesloten");
			return false;
		} else if (totalPoints <22) {
				return true;
			} //end if
		
		else {
			 for (BlackjackCard kaart : jeHand) {
				if (kaart.isAas == true && kaart.getPuntenWaard() != 1) {
				kaart.setPuntenWaard(1);
				return true;
				} //end if 
			} //end for loop
			
			System.out.println("oei je hebt er meer dan 21, je hebt verloren!");
			return false;
		} //end else
		
		
	} //end getaCard
	
	public void shuffleCards () { //schudden van de kaarten
		

		//dit stuk shuffelt de kaarten
		
		Collections.shuffle(deKaarten);
		for (BlackjackCard kaart : deKaarten) {
			System.out.println(kaart.getVorm() + kaart.getGetalOfPlaat());
			
		} //end for loop
		
		
	} //end shufflecards
		
	public void recountTotalPoints () {  //punten hertellen 
			totalPoints = 0;
		for (BlackjackCard kaarten : jeHand) {
			
			totalPoints += kaarten.getPuntenWaard();
		} //end for loop
		
	} //end recounttotalpoints
	
	public void resetAasPunten() {      //de asen moeten weer naar 11 gebracht worden als het spel reset word
		
		for (BlackjackCard kaarten : jeHand) {
			
			if (kaarten.isAas == true && kaarten.getPuntenWaard() == 1) {
				kaarten.setPuntenWaard(11);
			}
		} //end for loop
		
		
	} //end resetaaspunten
	
	
		
	} //end class
	
	

