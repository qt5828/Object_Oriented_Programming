package lab_B_11_201921195;

//CardTest.java
public class CardTest
{
   public static void main(String[] args)
   {
       CardDeck deck = new CardDeck();
		  System.out.println("After initializing...");
		  deck.printAll();
		  deck.shuffle();
		  System.out.println("After Shuffling...");
		  deck.printAll();
		  deck.sort();
		  System.out.println("After Sorting...");
		  deck.printAll();
   }
}