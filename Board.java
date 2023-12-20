import java.util.Scanner;
public class Board{
	Scanner sc = new Scanner(System.in);
	
	public Card[] boardCardsForUser = new Card[10]; // created a board for the game ; for each
	public Card[] boardCardsForCPU = new Card[10];  //  I ll keep it with 10;
	// I dont need to try to hide them , it s cpu's deck 
	public Deck BoardInstance = new Deck();
	
	public Board(){
			
	}
	
	public String game(){
		System.out.println("                     CPU") ;
		
		int cpuHasThatMuchCard = BoardInstance.getCpuDeckMain().length;
		for (int i = 0 ; i < cpuHasThatMuchCard ; i++){
			System.out.print("       X  ");
		}
		System.out.println("           ");
		System.out.println("           ");
		
		
		
		
		int indexCounterDeck=5;
		int boardCounterUser= 0 ;
		int boardCounterCpu=0;
		boardCardsForUser[boardCounterUser++]=BoardInstance.Deck[indexCounterDeck++];
		boardCardsForCPU[boardCounterCpu++]= BoardInstance.Deck[indexCounterDeck++];
		return (boardCardsForUser[0].getNumberAsInt()+" " + boardCardsForUser[0].Colour +" " + boardCardsForUser[0].Signs);
		
		
		
	} 
	
	
	public int method(){
	//boardCardsForUser[0]=BoardInstance.getUserDeckMain()[0];
		return BoardInstance.getUserDeckMainNumber(0);
	}
	
}
