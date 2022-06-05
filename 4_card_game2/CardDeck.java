
public class CardDeck {
	private static final int N = 52;
	private Card[] deck;
	private int top = 0;
	static final String[] cardSuits = {"Spade", "Diamond", "Heart", "Club"};
	
	public CardDeck()
	{
		int k = 0;
		deck = new Card[N];
		for(int i=0; i<4; i++)
			for(int j=1; j<14; j++)
				deck[k++] = new Card(j,cardSuits[i]);
	}
	public void shuffle()
	{
		int r=0, i=0;
		Card temp;
		
		for(i=0; i<N ; i++) {
			r = (int)(Math.random()*52);
			temp = deck[i];
			deck[i] = deck[r];
			deck[r] = temp;
		}
	}
	public Card dealCard()
	{
		return deck[top++];
	}
}
