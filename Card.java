public class Card {
	private String Colour;
	private String Number;
	
	
	public Card(String Colour, String Number ) {
			this.Colour= Colour;
			this.Number= Number;	
	}
	public String getColour() {
		return Colour;
	}
	public String getNumber() {
		return Number;
	}
	public String wholeCardToString() {
		return Colour + " " + 	Number + "  ";
	}
}
