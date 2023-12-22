import java.util.Scanner;
import java.util.Random;

public class Deck {
	private final String[] Colour = {"RED", "YELLOW","GREEN","BLUE"};
	private final String[] Number = {"1", "2", "3", "4", "5", "6", "7", "8", "9","10"};
	private final String[] Signs = { "+" , "-"};
	
	private Card temporaryCard;			  // will be used to shuffle the cards
	private int deckCreaterIndex= 0;      // will be used to create a desk
	private int deckCreaterIndex2= 0; 	  
	private int deckCreaterIndex3= 0; 
	private Card [] TopUpCards	;		  // will be used to add extra 3 cards to decks
	public Card[] Deck ;		// since now I have a deck , Cards can store 3 values
	private Card[] UserDeckNotMain ; // I need to get 10 cards for the user to select 4 of them.
	public Card[] UserDeckMain  ;	   // Selected 4 
	private Card[] CpuDeckNotMain ;  
	public Card[] CpuDeckMain  ;  
	private Card[] EmptyDeck;
	
	
	// I already assigned !!!!  boardCardsForUser and boardCardsForCPU in Board class.
	Scanner scan = new Scanner(System.in);
	Random rd = new Random();
	
			
	
	
    // Integer.parseInt(Deck[].Number);
	public Deck() { //// With this I succesfully created a game deck , each has a color, number value and a sign
		Deck = new Card [40];
		TopUpCards = new Card [48];    // I ll use them to add random cards to each players deck,
		UserDeckMain = new Card [4];
		UserDeckNotMain = new Card[10];
		CpuDeckMain = new Card[4];
		CpuDeckNotMain = new Card[10];
		for(int t = 0 ; t < Colour.length; t++){
			for (int n = 0 ; n < Number.length ; n++){
				Deck[deckCreaterIndex]=new Card(Colour[t] , Number [n], "+");  // all signs must be positive in the main deck.
				deckCreaterIndex++;
		
			}
		}
		
		
	}
	
	
	public void shuffle(){ 
			for( int i = 0 ; i < 40 ; i++){				// looping through all cards in the deck.
				int randIndex = rd.nextInt(40);			// generating a random number to replace 
				temporaryCard = Deck[randIndex];		// generated temp card to swap values
				Deck[randIndex] = Deck[i];
				Deck[i] = temporaryCard;
			}
	}
	
	public void giveCard ( ){                          // giving first 5 bottom cards to user , then 3 cards , then last 2 tricky cards 
		for ( int i = 0 ; i < 5; i++){                 // 	I M not deleting those cards from  main deck !!!!! be careful
			UserDeckNotMain[i] = Deck[39-i];
			Deck[39-i] = new Card (null,null,null);		     	// bu calısmıyor  , artık calısıyo
		}
		for (int t = 0 ; t<5 ;t++){
			CpuDeckNotMain[t] = Deck[t];
			Deck[t] = new Card (null,null,null);
		}
		// from now on I'am prepearing the pool for the extra 3 cards with  + - signs and 1 to 6 
		for(int t = 0 ; t < Colour.length; t++){
			for (int n = 0 ; n < 6 ; n++){
				TopUpCards[deckCreaterIndex2]=new Card(Colour[t] , Number [n], "+");  // positive 1 to 6 numbers with colours 
				deckCreaterIndex2++;
		
			}
		}
		for(int t = 0 ; t < Colour.length; t++){
			for (int n = 0 ; n < 6 ; n++){
				TopUpCards[deckCreaterIndex3+24]=new Card(Colour[t] , Number [n], "-");  // negative 1 to 6 numbers with colours 
				deckCreaterIndex3++;
			}
		}
		
		
		int randomValueforPicking; 		// we need to select 3 random cards for eachside
		int randomValueforPicking2;
		int randomValueforPicking3;
		int randomValueforPick;
		
		for( int i = 0 ; i < 3 ; i++){			// and I ADDED THEM to each players deck 
			
			randomValueforPicking = rd.nextInt(TopUpCards.length);
			randomValueforPicking2 = rd.nextInt(TopUpCards.length);
			CpuDeckNotMain[5+i] = TopUpCards[randomValueforPicking];
			UserDeckNotMain[5+i]= TopUpCards[randomValueforPicking2];
		}
		
		for ( int i = 0 ; i < 2 ; i++){		// I LL SELECT THE LAST 2 TRICKY CARDS
			randomValueforPicking= rd.nextInt(10)+1;		// this takes values 1 to 10 both inclusive
			randomValueforPicking2 = rd.nextInt(10)+1;
			randomValueforPicking3 = rd.nextInt(TopUpCards.length);
			
			if ( randomValueforPicking > 2 ) {      			// this is %80 
				CpuDeckNotMain[8+i] = TopUpCards[randomValueforPicking3];
			}else {												// this is %20
				if ( randomValueforPicking % 2 == 0 ){          
					CpuDeckNotMain[8 + i] = new Card("", "", "flip");
					
				}else{          
					 CpuDeckNotMain[8 + i] = new Card("", "", "double");
				}
				
			}
			if ( randomValueforPicking2 > 2 ) {      			// this is %80 
				UserDeckNotMain[8+i] = TopUpCards[randomValueforPicking3];
			}else {												// this is %20
				if ( randomValueforPicking2 % 2 == 0 ){          
					UserDeckNotMain[8 + i] = new Card("", "", "flip");
					
				}else{          
					 UserDeckNotMain[8 + i] = new Card("", "", "double");
				}
				
			}		
			
			
			
		}	//  ı am trying to get 4 random cards for each user and cpu ; for that I LL FIRST shuffle the decks which contains 10 cards ; then I LL assign values to user and cpu MAIN DECK 
		    // I am sure that this game is not unfair
		for( int i = 0 ; i < 10 ; i++){				// looping through all cards in the deck.
				int randIndex = rd.nextInt(10);			// generating a random number to replace 
				temporaryCard = UserDeckNotMain[randIndex];		// generated temp card to swap values
				UserDeckNotMain[randIndex] = UserDeckNotMain[i];
				UserDeckNotMain[i] = temporaryCard;
			}
		for( int i = 0 ; i < 10 ; i++){				// looping through all cards in the deck
				int randIndex = rd.nextInt(10);			// generating a random number to replace 
				temporaryCard = CpuDeckNotMain[randIndex];		// generated temp card to swap values
				CpuDeckNotMain[randIndex] = CpuDeckNotMain[i];
				CpuDeckNotMain[i] = temporaryCard;
			}
		randomValueforPicking = rd.nextInt(4);
		randomValueforPicking2 = rd.nextInt(4);
		for(int i = 0 ; i < 4 ; i++){
			CpuDeckMain[i] = CpuDeckNotMain[randomValueforPicking];
			UserDeckMain[i]= UserDeckNotMain[randomValueforPicking2];
			randomValueforPicking++;
			randomValueforPicking2++;
		}
	}
	
	
	
	//// my GET FUNCTIONS to get values from cards
	
	//public Card[] getCpuDeckMain(){
		//return CpuDeckMain;
	
	
								 
	public int getUserDeckMainNumber(int a){
		return UserDeckMain[a].getNumberAsInt();
	}
	public String getUserDeckMainColour(int a ){
		return UserDeckMain[a].getColour();
	}
	public String getUserDeckMainSigns(int a ) {
		return UserDeckMain[a].getSigns();
	}
	
	public int getCpuDeckMainNumber(int a){
		return CpuDeckMain[a].getNumberAsInt();
	}
	public String getCpuDeckMainColour(int a ){
		return CpuDeckMain[a].getColour();
	}
	public String getCpuDeckMainSigns(int a ) {
		return CpuDeckMain[a].getSigns();
	}
	
	
	
	public Card[] getCpuDeckMain(){
		return CpuDeckMain;
	}
	public String getUserDeckMain(int a ){
		return UserDeckMain[a].getColour();
	}
	public Card[] getDeck(){
		return Deck;
	}
		
	
	
    public void printDeck() {
    System.out.println("Deck contents:");
    for (Card card : Deck) {
        if (card != null) {
            System.out.println(card.wholeCardToString());
        }
    }
}

	public void printCpuDeckNotMain() {               // Assigned player cards but couldnt assess the values to null in main deck !
    System.out.println("CpuDeckNotMain contents:");
    for (Card card : CpuDeckNotMain) {
        if (card != null) {
            System.out.println(card.wholeCardToString());
        }
    }
}

public void printUserDeckNotMain() {
    System.out.println("UserDeckNotMain contents:");
    for (Card card : UserDeckNotMain) {
        if (card != null) {
            System.out.println(card.wholeCardToString());
        }
    }
}
public void printCpuDeckMain() {
    System.out.println("              CpuDeckMain contents:");
    for (Card card : CpuDeckMain) {
        System.out.print(card.wholeCardToString());
    }
	System.out.println();
}

public void printTopUpCards() {
    System.out.println("TopUpCards contents:");
    for (Card card : TopUpCards) {
        if (card != null) {
            System.out.println(card.wholeCardToString());
        }
    }
} 
public void printUserDeckMain() {
        System.out.println("             Your Deck");
        for (Card card : UserDeckMain) {
            System.out.print("" +card.wholeCardToString());
        }
		System.out.println();
    }


   
}
	

	
	
	
	