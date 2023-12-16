import java.util.Scanner;
import java.util.Random;

public class Deck {
	private final String[] Colour = {"RED", "YELLOW","GREEN","BLUE"};
	private final String[] Number = {"1", "2", "3", "4", "5", "6", "7", "8", "9","10"};
	private final String[] Signs = { "+" , "-"};
	
	private int deckCreaterIndex= 0; 
	private Card[] deck ;
	Scanner scan = new Scanner(System.in);
	Random rd = new Random();
	
			
	
	
	
	public Deck() { //// With this I succesfully created a game deck , each has a color, number value and a sign
		deck = new Card [40];
		
		for(int t = 0 ; t < Colour.length; t++){
			for (int n = 0 ; n < Number.length ; n++){
				deck[deckCreaterIndex]=new Card(Colour[t] , Number [n], "+"); 
				deckCreaterIndex++;
		
			}
		}
	}
	public static void main(String[] args){  // checking if it works, yes it does work. 
		Deck deckInstance = new Deck();
		for (int t = 0; t < deckInstance.deck.length; t++) {
        System.out.println(deckInstance.deck[t].wholeCardToString());
		}
	}
	
	public void shuffle(){   // 
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
