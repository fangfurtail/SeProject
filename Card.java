public class Card {

	public String Colour;
	private String Number;
	private String Signs;
	
	
	public Card(String Colour, String Number, String Signs ) {
			this.Colour= Colour;
			this.Number= Number;
			this.Signs = Signs;
	}
	public String getColour() {
		return Colour;
	}
	public String getNumber() {
		return Number;
	}
	public String getSigns(){
		return Signs;
	}
	public String wholeCardToString() {
		return Colour + " " + 	Number + "  " + Signs;
	}
	public static void main(String[] args){
		
		Card CardInstance = new Card("Red" , "10","+");
		System.out.println(CardInstance.wholeCardToString());
	}
}