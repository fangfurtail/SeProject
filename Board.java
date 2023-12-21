import java.util.Scanner;
public class Board{
	Scanner sc = new Scanner(System.in);
	
	public Card[] boardCardsForUser = new Card[10]; // created a board for the game ; for each
	public Card[] boardCardsForCPU = new Card[10];  //  I ll keep it with 10;
	// I dont need to try to hide them , it s cpu's deck 
	public Deck BoardInstance = new Deck();
		int indexCounterDeck=5;
		int boardCounterUser= 0 ;
		int boardCounterCpu=0;
		int userHasThatMuchCardOnBoard=1;
		int cpuHasThatMuchCardOnBoard = 1;
		
	public Board(){
			
	}
	
	public String game(){
		
		
		
		
		
		
		System.out.println("Your Choice --->  1) DRAW A CARD   2)MY CARD  3)STAND  4)SKIP ");
		int answer = sc.nextInt();

        switch (answer) {
            case 1:
                boardCardsForUser[boardCounterUser+1] = BoardInstance.Deck[indexCounterDeck];
				userHasThatMuchCardOnBoard = userHasThatMuchCardOnBoard + 1 ;
				System.out.println(userHasThatMuchCardOnBoard + " game");
                break;
            case 2:
                System.out.println("Which card would you like to select (1 - 4 )");
				int answer2 = sc.nextInt();
				switch (answer2) {
            case 1:
                  
                break;
            case 2:
                // Handle my card
                break;
            case 3:
                // Handle stand
                break;
            case 4:
                // Handle skip
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
				
				
				
				
				
				
				
				
                break;
            case 3:
                // Handle stand
                break;
            case 4:
                // Handle skip
                break;
            default:
                System.out.println("Invalid choice");
                break;
		
		
		
		
		
		
		
		
		
		
		
		
		}

		return  "" ;  // (boardCardsForUser[0].getNumberAsInt()+" " + boardCardsForUser[0].Colour +" " + boardCardsForUser[0].Signs);
		
		
		
		
	} 
	
	
	
	public String boardReaderUser (){
		

		
		
	for(int i = 0 ; i<userHasThatMuchCardOnBoard ; i++){              // I AM DEFINING THE FIRST BEGINNING BOARD           						
			boardCardsForUser[i] = BoardInstance.Deck[indexCounterDeck];
			indexCounterDeck ++;
			boardCounterUser++;
			boardCardsForCPU[i] = BoardInstance.Deck[indexCounterDeck];
			indexCounterDeck++;
			boardCounterCpu++;
		}	
		
		
		
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
		int scoreCpu = 0;
		
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