
public class CardTest3 {

	public static void main(String[] args)
	{
		Card c1 = new Card(2,"Club");
		Card c2 = new Card(2,"Club");
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		int result = c1.compareTo(c2);
		if(result > 0)
			System.out.println(c1.toString()+" wins "+c2.toString());
		else if(result < 0)
			System.out.println(c2.toString()+" wins "+c1.toString());
		else
			System.out.println(c1.toString()+" ties to "+c2.toString());
	}
}
