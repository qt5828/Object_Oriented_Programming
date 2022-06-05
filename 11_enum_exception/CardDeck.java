package lab_B_11_201921195;

//CardDeck.java
import java.util.*;
public class CardDeck
{  
    private static final int N = 52;
	   private Card[] deck;
    private int top=0;
    private Suit suit;
    static final Suit[] cardSuits = { Suit.SPADE, Suit.DIAMOND, Suit.HEART, Suit.CLUB };
    public CardDeck()
    {
        
       int k = 0;
		  deck = new Card[N];
		  for(int i=0; i<4; i++)
		  	for(int j=1; j<=13; j++)
			   deck[k++] = new Card(j, cardSuits[i]);
    }
    public Card deal()
    {
	      if(top>=N)
		  {
		  	System.out.println("no more card");
			System.exit(-1);
		  }
       return deck[top++];
    }
    public void shuffle()
    {
       for(int i=0; i<N; i++) 
		  {
		  	int j = (int) (Math.random()*N);
			Card temp = deck[i];
			deck[i] = deck[j];
			deck[j] = temp;
		  }
    }
	   public void sort()
	   {
	   	   Arrays.sort(deck);
	   }
	   public void printAll()
	   {
	   	  for(int i=0; i<52; i++)
		  {
		  	System.out.printf("%s : ",deck[i]);
			if((i+1)%4==0) System.out.printf("%n");
		  }
		  System.out.printf("%n");
	   }
	   
}