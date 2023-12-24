public class Main{
	public static void main(String[] args) {
			Board main = new Board();
			
			/*
			 Print UserDeckNotMain
			main.BoardInstance.printDeck();	
			main.BoardInstance.printUserDeckNotMain();
			main.BoardInstance.printCpuDeckNotMain();
			deckInstance.printTopUpCards();
			main.BoardInstance.printCpuDeckMain();
			System.out.println(main.boardReaderUser());  // bu default il raundu dağıtıyor
			System.out.println(main.boardReaderCpu());
			main.BoardInstance.printUserDeckMain();
			
			
			
		  	     	       ^
			             /  \
			               |
			               |
			               |
			               |
			 YOU CAN REACH ALL TOP VALUES AND PRINT THEM FROM HERE 
			
			*/
			
			
			
			
			
			
			
			
			
							// GAME STARTS 
							main.BoardInstance.shuffle();
							main.BoardInstance.giveCard(); //  gives card  and sets firt and last 5 value to null in main deck
							System.out.println(main.board());
							System.out.println(main.game());
						
			
		
	}
}