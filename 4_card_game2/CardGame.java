
public class CardGame {
	public static void main(String[] args)
	{
		CardDeck deck = new CardDeck();
		Card player1;
		Card player2;
		
		deck.shuffle();
		player1 = deck.dealCard();
		player2 = deck.dealCard();
		
		int result = player1.compareTo(player2);
		if(result > 0)
			System.out.println(player1.toString()+" wins "+player2.toString());
		else if(result < 0)
			System.out.println(player2.toString()+" wins "+player1.toString());
		else
			System.out.println(player1+" ties to "+player2);
	}
}
