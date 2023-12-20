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
		int scoreCpu = 0;
		int scoreUser = 0 ;
		
		
		
		
		//    !!!   bunları user değil cpu yapacaksın!!!    
		
		System.out.println("                     CPU") ;
		int cpuHasThatMuchCardOnDeck = 3;
		int cpuHasThatMuchCardOnHand = BoardInstance.getCpuDeckMain().length;
		for (int i = 0 ; i < cpuHasThatMuchCardOnHand ; i++){
			System.out.print("       X  ");
		}
		System.out.println("           ");
		System.out.println("           ");
		for(int i = 0 ; i < cpuHasThatMuchCardOnDeck ; i ++){ 
			if (BoardInstance.getCpuDeckMainSigns(i).equals("+")){
				System.out.print(BoardInstance.getCpuDeckMainSigns(i) + "" +BoardInstance.getCpuDeckMainNumber(i)+ " " + BoardInstance.getCpuDeckMainColour(i) + "    ");
				scoreCpu = scoreCpu + BoardInstance.getCpuDeckMainNumber(i);
			}else {
				System.out.print(BoardInstance.getCpuDeckMainSigns(i) + "" +BoardInstance.getCpuDeckMainNumber(i)+ " " + BoardInstance.getCpuDeckMainColour(i) + "    ");
				scoreCpu = scoreCpu - BoardInstance.getCpuDeckMainNumber(i);
			}	
		}
		System.out.println(scoreCpu);
		
		
		
		
		
		
		
		
		
		
		int indexCounterDeck=5;
		int boardCounterUser= 0 ;
		int boardCounterCpu=0;
		boardCardsForUser[boardCounterUser++]=BoardInstance.Deck[indexCounterDeck++];
		boardCardsForCPU[boardCounterCpu++]= BoardInstance.Deck[indexCounterDeck++];
		return  "kaan" ;  // (boardCardsForUser[0].getNumberAsInt()+" " + boardCardsForUser[0].Colour +" " + boardCardsForUser[0].Signs);
		
		
		
	} 
	
	
	public int method(){
	//boardCardsForUser[0]=BoardInstance.getUserDeckMain()[0];
		return BoardInstance.getUserDeckMainNumber(0);
	}
	
}
