package blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {

	public String getInput () {
		String inputLine = null;
		
		try {
			BufferedReader inputje = new BufferedReader (new InputStreamReader(System.in)); 
			inputLine = inputje.readLine();
			if (inputLine.length() == 0) return null;   //test if line is empty
		} catch (IOException ex) {
			System.out.println(ex);
			
		} //end try and catch
		
		
		
		return inputLine.toLowerCase(); //dit is de string die genomen wordt
		
	} //end getInput
	
	
}
