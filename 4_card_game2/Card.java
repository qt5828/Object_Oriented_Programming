
public class Card {
	private int rank;
	private String suit;
	
	public Card(int r, String s)
	{
		rank = r;
		suit = s;
	}
	public int getRank() 
	{
		return this.rank;
	}
	public String getSuit()
	{
		return this.suit;
	}
	public String toString()
	{
		String Rank="";
		switch (this.rank) {
		case 1 :
			Rank="Ace";
			break;
		case 2 :
			Rank="2";
			break;
		case 3 :
			Rank="3";
			break;
		case 4 :
			Rank="4";
			break;
		case 5 :
			Rank="5";
			break;
		case 6 :
			Rank="6";
			break;
		case 7 :
			Rank="7";
			break;
		case 8 :
			Rank="8";
			break;
		case 9 :
			Rank="9";
			break;
		case 10 :
			Rank="10";
			break;
		case 11 :
			Rank="Jack";
			break;
		case 12 :
			Rank="Queen";
			break;
		case 13 :
			Rank="King";
			break;	
		}
		return (Rank+" of "+suit);
	}
	public int compareTo(Card other)
	{
		if (this.rank > other.rank)
		{
			if (other.rank == 1)
				return -1;
			else
				return 1;
				
		}
		else if (this.rank < other.rank)
		{
			if(this.rank == 1)
				return 1;
			else
				return -1;
		}
		else 
		{
			if(this.suit==other.suit)
				return 0;
			else
			{
				if(this.suit=="Spade")
					return 1;
				else if(other.suit=="Spade")
					return -1;
				else {
					if(this.suit=="Diamond")
						return 1;
					else if(other.suit=="Diamond")
						return -1;
					else {
						if(this.suit=="Heart")
							return 1;
						else if(other.suit=="Heart")
							return -1;
					}
					
				}
				
			}
		}
		return 0;
	}
}
