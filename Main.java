public class Main{
 public static void main(String[] args) {
		Board main = new Board();
        main.BoardInstance.shuffle();

        // Print the entire deck
       

        // Print UserDeckNotMain
        main.BoardInstance.giveCard();
		main.BoardInstance.printDeck();
        main.BoardInstance.printUserDeckNotMain();
		main.BoardInstance.printCpuDeckNotMain();
		//deckInstance.printTopUpCards();
		main.BoardInstance.printCpuDeckMain();
		main.BoardInstance.printUserDeckMain();
		System.out.println(main.method());
		System.out.println(main.game());
		
    }
}