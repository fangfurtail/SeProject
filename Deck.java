import java.util.Scanner;
import java.util.Random;

public class Deck {
	private final String[] Colour = {"RED", "YELLOW","GREEN","BLUE"};
	private final String[] Number = {"1", "2", "3", "4", "5", "6", "7", "8", "9","10"};
	private final String[] Signs = { "+" , "-");
	
	private int deckCreaterIndex= 0; 
	private Card[] deck ;
	Scanner scan = new Scanner(System.in);
	Random rd = new Random();
	
			}
	
	
	
	public Deck() {
		deck = new Card [40];
		
		for(int t = 0 ; t < Colour.length; t++){
			for (int n = 0 ; n < Number.length ; n++){
				deck[deckCreaterIndex]=new Card(Colour[t] , Number [n], "+"); 
				deckCreaterIndex++;
		
	}


