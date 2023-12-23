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
		int scoreCpu = 0;
		int scoreUser=0;
		
		
		
		
		
		
		
	public String board(){
			boardCardsForUser[0] = BoardInstance.Deck[indexCounterDeck];    //FIRST CARD ON THE TABLE IS NOT DEPENDING ON THE USER'S  CHOICE SO I ASSIGNED  IT HERE 
			indexCounterDeck++;
			
			boardCardsForCPU[0] = BoardInstance.Deck[indexCounterDeck];
			indexCounterDeck++;	
		return "";
	}
	
	
	
	
	
	public String game(){
		boolean keyToUser = true;
		boolean keyToCpu =  true;
		int answer;
		int kaan = 0 ;
	
		while (kaan < 5 ){
			kaan++;
			
			
			System.out.println("\n\n\n\n\n\n\n\n");
			BoardInstance.printCpuDeckMain();
			boardReaderCpu ();
			boardReaderUser();
			BoardInstance.printUserDeckMain();
			
			
			while (keyToUser){
				keyToCpu =  true;
				System.out.println("Your Choice --->  1) DRAW A CARD   2)MY CARD  3)STAND  4)SKIP ");
				answer = sc.nextInt();
				switch (answer) {
					case 1:
						boardCardsForUser[indexBoardUser++] = BoardInstance.Deck[indexCounterDeck];
						indexCounterDeck ++;
						userHasThatMuchCardOnBoard = userHasThatMuchCardOnBoard + 1 ;
						System.out.println(userHasThatMuchCardOnBoard + " game");
						keyToUser= false;
						
						break;
					case 2:
						System.out.println("WHICH CARD : 1 , 2 , 3 , 4");
						int answer2 = sc.nextInt();
						if (answer2 >= 1 && answer2 <= 4) {
							boardCardsForUser[indexBoardUser++] = BoardInstance.UserDeckMain[answer2 - 1];
							userHasThatMuchCardOnBoard = userHasThatMuchCardOnBoard + 1 ;
							keyToUser= false;
							
					
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
			
			
			
				
						for( int a = 0 ; a < 4 ; a++){
							if(getDeckCardsForCpuNumber(a)+ scoreCpu >17 && getDeckCardsForCpuNumber(a)+ scoreCpu <=20){
							boardCardsForCPU[indexBoardCpu++]=BoardInstance.CpuDeckMain[a];
							cpuHasThatMuchCardOnBoard++;
							keyToUser= true;
								break;
							// there is no indexCounterDeck because cpu is taking the card from its deck
							}else{
								if(scoreCpu <= 15 ){
								boardCardsForCPU[indexBoardCpu++] = BoardInstance.Deck[indexCounterDeck];
								cpuHasThatMuchCardOnBoard = cpuHasThatMuchCardOnBoard+1;
								indexCounterDeck++;
								
								keyToUser= true;
								break;
								}
								break;
							}
						}
				
		}
	
		
		
		return  "" ;
		
		
				
		
		
		}
	
	
	
	
	public String boardReaderUser (){
		
	int scoreUser = 0 ;
	 	


		//  kart ttıkca artacak
		System.out.print("          " );
		
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
	
	
	
	public String boardReaderCpu (){     // With that I am able to read the deck and calculate the in game scores FOR CPU 
	
		        
		
		scoreCpu = 0;
		
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
	
	
	
	
	
	
	
	
	// get functions 
	
	
	
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
	
	public int getDeckCardsForCpuNumber(int a ) {                           // For reading Cpu 
		if( BoardInstance.CpuDeckMain[a].getNumberAsInt() < 0){
			return  -1 * BoardInstance.CpuDeckMain[a].getNumberAsInt();
		}else {
			return BoardInstance.CpuDeckMain[a].getNumberAsInt();
		}
	}	
	
	public String getBoardCardsForCpuColour(int a ){
		return boardCardsForCPU[a].getColour();
	}
	public String getBoardCardsCpuUserSigns(int a ) {
		return boardCardsForCPU[a].getSigns();
	}
	
	
	
	
}