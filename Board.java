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
		
		
		int cpuHasThatMuchCardOnHand =(int)BoardInstance.getCpuDeckMain().length;		// It prints out the Cards which are hidden
		for (int i = 0 ; i < cpuHasThatMuchCardOnHand ; i++){                          
			System.out.print("       X  ");
		}
		System.out.println("           ");
		System.out.println("           ");
		
	
		
		int indexCounterDeck=5;
		int boardCounterUser= 0 ;
		int boardCounterCpu=0;
		
		boardCardsForUser[boardCounterUser++]=BoardInstance.Deck[indexCounterDeck++];
		boardCardsForCPU[boardCounterCpu++]= BoardInstance.Deck[indexCounterDeck++];
		return  "kaan" ;  // (boardCardsForUser[0].getNumberAsInt()+" " + boardCardsForUser[0].Colour +" " + boardCardsForUser[0].Signs);
		
		
		
	} 
	
	
	
	public String boardReaderUser (){
	int scoreUser = 0 ;
		int userHasThatMuchCardOnBoard=3;  		//  kart ttıkca artacak
		for(int i = 0 ; i < userHasThatMuchCardOnBoard ; i ++){ 
			if (BoardInstance.getUserDeckMainSigns(i).equals("+")){
				System.out.print(BoardInstance.getUserDeckMainSigns(i) + "" +BoardInstance.getUserDeckMainNumber(i)+ " " + BoardInstance.getUserDeckMainColour(i) + "    ");
				scoreUser = scoreUser + BoardInstance.getUserDeckMainNumber(i);
			}else if (BoardInstance.getUserDeckMainSigns(i).equals("-")){
				System.out.print(BoardInstance.getUserDeckMainSigns(i) + "" +BoardInstance.getUserDeckMainNumber(i)+ " " + BoardInstance.getUserDeckMainColour(i) + "    ");
				scoreUser = scoreUser - BoardInstance.getUserDeckMainNumber(i);
			}else if (BoardInstance.getUserDeckMainSigns(i).equals("flip")){
				System.out.print("  +/-  " );
				scoreUser  = scoreUser + -2 * BoardInstance.getUserDeckMainNumber(i-1);
			}else {
				System.out.print(" x2 " );	
				scoreUser = scoreUser + BoardInstance.getUserDeckMainNumber(i-1);
			}
		}	
			
		System.out.println( " User's Current Score  is " + scoreUser +   "   "  );
		return " " ;
	}
	
	
	
	
	
	
	
	
	
	
	public String boardReaderCpu (){     // tam fonksiyonlu değil
		int scoreCpu = 0;
		int cpuHasThatMuchCardOnBoard = 3 ;    		   // kart attıkca artacak 
		for(int i = 0 ; i < cpuHasThatMuchCardOnBoard ; i ++){ 
			if (BoardInstance.getCpuDeckMainSigns(i).equals("+")){
				System.out.print(BoardInstance.getCpuDeckMainSigns(i) + "" +BoardInstance.getCpuDeckMainNumber(i)+ " " + BoardInstance.getCpuDeckMainColour(i) + "    ");
				scoreCpu = scoreCpu + BoardInstance.getCpuDeckMainNumber(i);
			}else if (BoardInstance.getCpuDeckMainSigns(i).equals("-")){
				System.out.print(BoardInstance.getCpuDeckMainSigns(i) + "" +BoardInstance.getCpuDeckMainNumber(i)+ " " + BoardInstance.getCpuDeckMainColour(i) + "    ");
				scoreCpu = scoreCpu - BoardInstance.getCpuDeckMainNumber(i);
			}else if (BoardInstance.getCpuDeckMainSigns(i).equals("flip")){
				System.out.print("    +/-    " );
				scoreCpu = scoreCpu + -2 * BoardInstance.getCpuDeckMainNumber(i-1);
			}else {
				System.out.print("   x2    " );
				scoreCpu = scoreCpu + BoardInstance.getCpuDeckMainNumber(i-1);
			}
		}
		System.out.println( " Computers Current Score  is " + scoreCpu);
		return " " ;
		}		
	
	
	
	
	public int method(){
	//boardCardsForUser[0]=BoardInstance.getUserDeckMain()[0];
		return BoardInstance.getUserDeckMainNumber(0);
	}
	
}
