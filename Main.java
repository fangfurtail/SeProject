public class Main{
 public static void main(String[] args) {
		Board main = new Board();
        main.BoardInstance.shuffle();

        // Print the entire deck
       

        // Print UserDeckNotMain
        main.BoardInstance.giveCard();        //  gives card  and sets firt and last 5 value to null in main deck
		main.BoardInstance.printDeck();	
       // main.BoardInstance.printUserDeckNotMain();
		//main.BoardInstance.printCpuDeckNotMain();
		//deckInstance.printTopUpCards();
		//main.BoardInstance.printCpuDeckMain();
		//main.BoardInstance.printUserDeckMain();
		//System.out.println(main.method());
		//System.out.println(main.BoardInstance.getUserDeckMain(2));
		System.out.println(main.game());
		System.out.println(main.boardReaderCpu());
		System.out.println(main.boardReaderUser());
    }
}