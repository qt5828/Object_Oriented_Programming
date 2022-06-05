
public class CardTest1 {
	public static void main(String[] args)
	{
		Card c1 = new Card(1,"Spade");
		Card c2 = new Card(2,"Heart");
		System.out.println("Suit : "+c1.getSuit()+", "+"Rank : "+c1.getRank());
		System.out.println("Suit : "+c2.getSuit()+", "+"Rank : "+c2.getRank());
	}
}
