package lab_B_11_201921195;


// Card.java
public class Card implements Comparable<Card>
{  
    private int rank;
    private Suit suit;
	static final Suit[] cardSuits = { Suit.SPADE, Suit.DIAMOND, Suit.HEART, Suit.CLUB };
    
    public Card(int r, Suit s)
    {
        rank = r;
        suit = s;
    }
    public int getRank()
    {
       return rank;
    }
    public Suit getSuit()
    {
       return suit;
    }
	   public String toString()
	   {
	   	  String temp;
		  switch(rank)
		  {
		  	case 1: temp="ace"; break;
			case 11: temp ="jack"; break;
			case 12: temp ="queen"; break;
			case 13: temp = "king"; break;
			default : temp = ""+rank;
		  }
		  return temp+" of "+suit;
		
	   }
	   public int compareTo(Card other)
	   {
	   	  int result;
		  int a = this.rank;
		  int b = other.rank;
		  
		  if(a==1) a=14; // ace
		  if(b==1) b=14;
		  if(a > b) return 1;
		  else if (a < b) return -1;
		  for(int j=0; j<4; j++)
		    if(this.suit.equals(cardSuits[j]))
			{
				a = j; break;
			}
		  for(int j=0; j<4; j++)
			if(other.suit.equals(cardSuits[j]))
			{
				b = j; break;
			}
		  if(a<b) return 1;
		  else if(a>b) return -1;
		  return 0;
		  
	   }
}