package blackjack;

public class BlackJackTest {

	public void startUp () {
		
		System.out.println("startup setup!");
		int getal = 6;
		int getal2 = 5;
		char letter1 = 72;
		System.out.println("het gatal is " + getal + " en " + getal2);
		int uitkomst = getal + getal2;
		
		System.out.println("het gatal is " + uitkomst);
		
		TestVoorLeraar persoon1 = new TestVoorLeraar();
		TestVoorLeraar persoon2 = new TestVoorLeraar();
		
		persoon1.gewicht = 30;
		persoon2.gewicht = 20;
		
		if (persoon1.gewicht > 10) {
			
			System.out.println("oeii je bent te dik");
		} else if (persoon1.gewicht < 10) {
			
			System.out.println("slank hoor");
		}
		
		
		
		
		
		
	}
	
}
