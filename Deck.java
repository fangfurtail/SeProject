import java.util.Scanner;
import java.util.Random;

public class Deck {
	private final String[] Colour = {"RED", "YELLOW","GREEN","BLUE"};
	private final String[] Number = {"1", "2", "3", "4", "5", "6", "7", "8", "9","10"};
	private final String[] Signs = { "+" , "-"};
	
	private Card temporaryCard;			  // will be used to shuffle the cards
	private int deckCreaterIndex= 0;      // will be used to create a desk
	private Card[] Deck ;		// since now I have a deck , Cards can store 3 values
	private Card[] UserDeckNotMain ; // I need to get 10 cards for the user to select 4 of them.
	private Card[] UserDeckMain  ;	   // Selected 4 
	private Card[] CpuDeckNotMain ;  
	private Card[] CpuDeckMain  ;  
	
	
	// I already assigned !!!!  boardCardsForUser and boardCardsForCPU in Board class.
	Scanner scan = new Scanner(System.in);
	Random rd = new Random();
	
			
	
	
	
	public Deck() { //// With this I succesfully created a game deck , each has a color, number value and a sign
		Deck = new Card [40];
		UserDeckMain = new Card [4];
		UserDeckNotMain = new Card[10];
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
	
	public void giveCard ( ){                          // giving first 5 bottom cards to user 
		for ( int i = 0 ; i < 5 ; i++){
			UserDeckNotMain[i] = Deck[39-i];
		}
	}
	
	
	

	
	 public void printUserDeckNotMain() {
        System.out.println("UserDeckNotMain in icindekiler:");
        for (Card card : UserDeckNotMain) {
            System.out.println(card.wholeCardToString());
        }
    }
	 public static void main(String[] args) {
        Deck deckInstance = new Deck();
        deckInstance.shuffle();
        deckInstance.giveCard();

        // Print UserDeckNotMain
        deckInstance.printUserDeckNotMain();
	 }
}
	
	
	
	
	
	
	
	/*
	String tempValue =" " ;
String [] arr = {"a","b","c","d","e"};
for(int t =  0 ; t < arr.length ; t++ ){
	int randIndex = rd.nextInt(arr.length);
tempValue = arr[randIndex]; 
arr[randIndex] = arr[t];
arr[t]= tempValue;

}
System.out.println("shuffld  ARRAY");
        for (String element : arr) {
            System.out.println(element);
        }
}
}

/*a rd 1 3
b 2
c 3  i 1
int b = int a ;
a 1
b 1 
c 3
a = c 
c = b 
a 3
b 1
c 1
I LL IMPLEMENT THIS SHUFFLING ALGORITHM TO MY PROJECT !
 */
