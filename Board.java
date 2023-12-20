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
		
		
		System.out.println("                     CPU");
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
		
		
		for(int i = 0 ; i<4; i++){
			boardCardsForUser[i] = BoardInstance.Deck[indexCounterDeck];
			indexCounterDeck ++;
			boardCardsForCPU[i] = BoardInstance.Deck[indexCounterDeck];
			indexCounterDeck++;
		}
		
		System.out.println(boardCardsForUser[2].getColour());
		
		System.out.println(getBoardCardsForUserNumber(2));
		
		
		
		
		
		
		
		
		
		boardCardsForUser[boardCounterUser++]=BoardInstance.Deck[indexCounterDeck++];
		boardCardsForCPU[boardCounterCpu++]= BoardInstance.Deck[indexCounterDeck++];
		return  "" ;  // (boardCardsForUser[0].getNumberAsInt()+" " + boardCardsForUser[0].Colour +" " + boardCardsForUser[0].Signs);
		
		
		
		
	} 
	
	
	
	public String boardReaderUser (){
	int scoreUser = 0 ;
		int userHasThatMuchCardOnBoard=3;  		//  kart ttıkca artacak
		for(int i = 0 ; i < userHasThatMuchCardOnBoard ; i ++){ 
			if (getBoardCardsForUserSigns(i).equals("+")){
				System.out.print(getBoardCardsForUserSigns(i) + "" +getBoardCardsForUserNumber(i)+ " " + getBoardCardsForUserColour(i) + "    ");
				scoreUser = scoreUser + getBoardCardsForUserNumber(i);
			}else if (getBoardCardsForUserSigns(i).equals("-")){
				System.out.print(getBoardCardsForUserSigns(i) + "" +getBoardCardsForUserNumber(i)+ " " + getBoardCardsForUserColour(i) + "    ");
				scoreUser = scoreUser - getBoardCardsForUserNumber(i);
			}else if (getBoardCardsForUserSigns(i).equals("flip")){
				System.out.print("  +/-  " );
				scoreUser  = scoreUser + -2 * getBoardCardsForUserNumber(i-1);
			}else {
				System.out.print(" x2 " );	
				scoreUser = scoreUser + getBoardCardsForUserNumber(i-1);
			}
		}	
			
		System.out.println( " User's Current Score  is " + scoreUser +   "   "  );
		return " " ;
	}
	
	
	
	public String boardReaderCpu (){     // tam fonksiyonlu değil
		int scoreCpu = 0;
		int cpuHasThatMuchCardOnBoard = 3 ;    		   // kart attıkca artacak 
		for(int i = 0 ; i < cpuHasThatMuchCardOnBoard ; i ++){ 
			if (getBoardCardsCpuUserSigns(i).equals("+")){
				System.out.print(getBoardCardsCpuUserSigns(i) + "" +getBoardCardsForCpuNumber(i)+ " " + getBoardCardsForCpuColour(i) + "    ");
				scoreCpu = scoreCpu + getBoardCardsForCpuNumber(i);
			}else if (getBoardCardsCpuUserSigns(i).equals("-")){
				System.out.print(getBoardCardsCpuUserSigns(i) + "" +getBoardCardsForCpuNumber(i)+ " " + getBoardCardsForCpuColour(i) + "    ");
				scoreCpu = scoreCpu - getBoardCardsForCpuNumber(i);
			}else if (getBoardCardsCpuUserSigns(i).equals("flip")){
				System.out.print("    +/-    " );
				scoreCpu = scoreCpu + -2 * getBoardCardsForCpuNumber(i-1);
			}else {
				System.out.print("   x2    " );
				scoreCpu = scoreCpu + getBoardCardsForCpuNumber(i-1);
			}
		}
		System.out.println( " Computers Current Score  is " + scoreCpu);
		return " " ;
		}		
	
	
	public int getBoardCardsForUserNumber(int a){
		return boardCardsForUser[a].getNumberAsInt();
	}
	public String getBoardCardsForUserColour(int a ){
		return boardCardsForUser[a].getColour();
	}
	public String getBoardCardsForUserSigns(int a ) {
		return boardCardsForUser[a].getSigns();
	}
	
	
	public int getBoardCardsForCpuNumber(int a){
		return boardCardsForCPU[a].getNumberAsInt();
	}
	public String getBoardCardsForCpuColour(int a ){
		return boardCardsForCPU[a].getColour();
	}
	public String getBoardCardsCpuUserSigns(int a ) {
		return boardCardsForCPU[a].getSigns();
	}
	
	

	
	
	
	
	
	public int method(){
	//boardCardsForUser[0]=BoardInstance.getUserDeckMain()[0];
		return BoardInstance.getUserDeckMainNumber(0);
	}
	
}
