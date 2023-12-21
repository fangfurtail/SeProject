import java.util.Scanner;
public class Board{
	Scanner sc = new Scanner(System.in);
	
	public Card[] boardCardsForUser = new Card[10]; // created a board for the game ; for each
	public Card[] boardCardsForCPU = new Card[10];  //  I ll keep it with 10;
	// I dont need to try to hide them , it s cpu's deck 
	public Deck BoardInstance = new Deck();
		int indexCounterDeck=5;
		int indexBoardUser= 1 ;
		int indexBoardCpu=1;
		int userHasThatMuchCardOnBoard=1;
		int cpuHasThatMuchCardOnBoard = 1;
		
	public Board(){
			
	}
	
	public String game(){
		
		
		
		
		
		
		System.out.println("Your Choice --->  1) DRAW A CARD   2)MY CARD  3)STAND  4)SKIP ");
		
		boolean key = true;
		while (key){
			int answer = sc.nextInt();
			switch (answer) {
				case 1:
					boardCardsForUser[indexBoardUser++] = BoardInstance.Deck[indexCounterDeck];
				indexCounterDeck ++;
					userHasThatMuchCardOnBoard = userHasThatMuchCardOnBoard + 1 ;
					System.out.println(userHasThatMuchCardOnBoard + " game");
					key= false;
					
					break;
				case 2:
					System.out.println("WHICH CARD : 1 , 2 , 3 , 4");
					int answer2 = sc.nextInt();
					if (answer2 >= 1 && answer2 <= 4) {
						boardCardsForUser[indexBoardUser++] = BoardInstance.UserDeckMain[answer2 - 1];
						userHasThatMuchCardOnBoard = userHasThatMuchCardOnBoard + 1 ;
					key= false;
				
					}else {
						System.out.println("Invalid card selection");
				
					}
				
					break;
				case 3:
					
					break;
				case 4:
					// Skip
					break;
				default:
				 
					System.out.println("Invalid choice");
					break;
			}
		}
		return  "" ;  // (boardCardsForUser[0].getNumberAsInt()+" " + boardCardsForUser[0].Colour +" " + boardCardsForUser[0].Signs);
		
		
				
		
		
	} 
	
	
	
	public String boardReaderUser (){
		
	boardCardsForUser[0] = BoardInstance.Deck[indexCounterDeck];
		
		
	/*for(int i = 0 ; i<2 ; i++){              // I AM DEFINING THE FIRST BEGINNING BOARD           						
			boardCardsForUser[i] = BoardInstance.Deck[indexCounterDeck];
			indexCounterDeck ++;
			indexBoardUser++;
			boardCardsForCPU[i] = BoardInstance.Deck[indexCounterDeck];
			//indexCounterDeck++;
			indexBoardCpu++;
		}	
		*/
		
		
	int scoreUser = 0 ;
	 	


		//  kart ttıkca artacak
		System.out.print("          " );
		System.out.println(userHasThatMuchCardOnBoard + " board");
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
			
		System.out.println( "                User's Current Score  is " + scoreUser +   "   "  );
		return " " ;
	}
	
	
	
	public String boardReaderCpu (){     // tam fonksiyonlu değil
	
		boardCardsForCPU[0] = BoardInstance.Deck[indexCounterDeck];
		
		int scoreCpu = 0;
		boardCardsForCPU[0] = BoardInstance.Deck[indexCounterDeck];
		System.out.print("          " );
		for(int i = 0 ; i < cpuHasThatMuchCardOnBoard ; i ++){ 
		
			if (getBoardCardsCpuUserSigns(i).equals("+")){
				System.out.print("" +getBoardCardsCpuUserSigns(i) + "" +getBoardCardsForCpuNumber(i)+ " " + getBoardCardsForCpuColour(i) + "    ");
				scoreCpu = scoreCpu + getBoardCardsForCpuNumber(i);
			}else if (getBoardCardsCpuUserSigns(i).equals("-")){
				System.out.print("  " +getBoardCardsCpuUserSigns(i) + "" +getBoardCardsForCpuNumber(i)+ " " + getBoardCardsForCpuColour(i) + "    ");
				scoreCpu = scoreCpu - getBoardCardsForCpuNumber(i);
			}else if (getBoardCardsCpuUserSigns(i).equals("flip")){
				System.out.print("  +/-    " );
				scoreCpu = scoreCpu + -2 * getBoardCardsForCpuNumber(i-1);
			}else {
				System.out.print("   x2    " );
				scoreCpu = scoreCpu + getBoardCardsForCpuNumber(i-1);
			}
		}
		System.out.println( "               Computers Current Score  is " + scoreCpu);
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