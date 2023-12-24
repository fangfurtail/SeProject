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
	private int userWin=0;
	private int cpuWin=0;
	public	int scoreUserToCompare = 0 ;
	public int scoreCpuToCompare = 0 ;
		
		
		
		
		
		
	public String board(){
			boardCardsForUser[0] = BoardInstance.Deck[indexCounterDeck];    //FIRST CARD ON THE TABLE IS NOT DEPENDING ON THE USER'S  CHOICE SO I ASSIGNED  IT HERE 
			indexCounterDeck++;
			
			boardCardsForCPU[0] = BoardInstance.Deck[indexCounterDeck];
			indexCounterDeck++;	
		return "";
	}
	
	
	
	
	
	public String game(){
		System.out.println(board());
		boolean keyToUser = true;
		boolean mainKeyToUser = true;   //   case 2 olursa User play loopuna girmeyecek .
		
		boolean keyToCpu =  true;
		boolean keyToCpuMain =  true;
		int answer;
		int kaan = 0 ;
		boolean keyKey = true;
		boolean enough= true;
		
	
		while ( cpuWin <= 3 || userWin <= 3){
			if (cpuWin == 3){
				System.out.println("Cpu won");
				break;
			}else if (userWin == 3){
				System.out.println("User won");
				break;
			}
		
	
		while ((keyToCpuMain||mainKeyToUser || kaan <6)&&keyKey){
			
			
			
			
			
			
			
			kaan++;
			if(kaan>9){
				keyToCpuMain = false;
				mainKeyToUser = false;
			}
			System.out.println("\n\n\n\n\n\n\n\n " + scoreUserToCompare+  "  sex  ");
			BoardInstance.printCpuDeckMain();
			
			boardReaderCpu ();
			boardReaderUser();
		
			
			
			System.out.println("\n\n\n\n\n\n\n\n " + scoreUserToCompare+  "  sex  ");
			BoardInstance.printUserDeckMain();
			
			if(scoreUserToCompare>26){
				break;
			}
			else{
		boolean control=true;
			for( int s = 0 ; s < 4 ; s++){
				if(BoardInstance.UserDeckMain[s].getSigns().equals("-")&&(scoreUserToCompare-BoardInstance.UserDeckMain[s].getNumberAsInt()<=20)){
					control = false;
				}
			}
			if( control &&  scoreUserToCompare >20){
					
					break;
					
				}	
			}
			
			
			
			while (keyToUser && mainKeyToUser){
				System.out.println("69");
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
							mainKeyToUser = false;
							keyToCpu= true;
							
							
							
					
						}else {
							System.out.println("Invalid card selection");
					
						}
					
						break;
					case 3:
					if(!keyToCpuMain){
						keyKey = false;
					}
					keyToUser =false;
					keyToCpu= true;
						break;
						
						
					case 4:
						keyToUser =false;
						break;
					default:
					 
						System.out.println("Invalid choice");
						break;
				}
			keyToCpu=true;
			}
			
			
			
			int tracker = 0 ;
				while( keyToCpu ){
						tracker++;
					if(tracker > 15){
						break;
					}
					//System.out.println("31");
						if (keyToCpuMain){
						for( int a = 0 ; a < 4 ; a++){
										if(getDeckCardsForCpuNumber(a)+ scoreCpuToCompare >= 17 && getDeckCardsForCpuNumber(a)+ scoreCpuToCompare <20){
										boardCardsForCPU[indexBoardCpu++]=BoardInstance.CpuDeckMain[a];
										cpuHasThatMuchCardOnBoard++;
										keyToUser= true;	
										keyToCpu = false;	
										keyToCpuMain =  false;
										break;
															// there is no indexCounterDeck because cpu is taking the card from its deck
										}
						}
						}
							if (keyToCpuMain && scoreCpuToCompare < 14 ){
							boardCardsForCPU[indexBoardCpu++] = BoardInstance.Deck[indexCounterDeck];
											cpuHasThatMuchCardOnBoard = cpuHasThatMuchCardOnBoard+1;
											indexCounterDeck++;
											keyToUser = true ;
											break;
											
											
							}
							
						keyToUser=true;
						}
					
						
			
			
		
		
		}
		
		
		System.out.println( scoreCpuToCompare+ " cpu  ---------- " + scoreUserToCompare + " user " );
		if(scoreCpuToCompare <= 20 && scoreUserToCompare<=20){
			if(scoreCpuToCompare > scoreUserToCompare){
				cpuWin++;
				System.out.println("Cpu just earned a point");
				break;
				
				
			}else if (scoreCpuToCompare < scoreUserToCompare){
				userWin++;
				System.out.println("User just earned a point");
				break;
			}
		}else if(scoreUserToCompare > 20 ){
			cpuWin++;
			System.out.println("Cpu just earned a point");
		}
		
		
			
	}
		return "31";
	}
	
	
	
	public String boardReaderUser (){
		
	
		
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
			scoreUserToCompare = scoreUser;
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
		scoreCpuToCompare = scoreCpu;
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
	
	public int getDeckCardsForCpuNumber(int a ) {                           // For reading Cpu 
		if( BoardInstance.CpuDeckMain[a].getSigns().equals("-")){
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
	
	
	public int method(){
	//boardCardsForUser[0]=BoardInstance.getUserDeckMain()[0];
		return BoardInstance.getUserDeckMainNumber(0);
	}
	
}