package lab_B_9_201921195;

/**
 * This program demonstrates the equals method.
 * @version 1.12 2012-01-26
 * @author Cay Horstmann
 */
public class ObjectClassTest
{
   public static void main(String[] args)
   {
      Employee alice1 = new SalariedEmployee("Alice Adams", "11111", 1000.0);
      Employee alice2 = alice1;
      Employee alice3 = new SalariedEmployee("Alice Adams", "11111", 1000.0);
      
      Employee bob1 = new CommissionEmployee("Bob", "11112", 1000.0, 0.2);
      Employee bob2 = bob1;
      Employee bob3 = new CommissionEmployee("Bob", "11112", 1000.0, 0.2);
      
      Employee david1 = new HourlyEmployee("David", "11113", 5000.0, 5.0);
      Employee david2 = david1;
      Employee david3 = new HourlyEmployee("David", "11113", 5000.0, 5.0);
      
      Employee frank1 = new Manager("Frank", "11114", 2000.0);
      Employee frank2 = frank1;
      Employee frank3 = new Manager("Frank", "11114", 2000.0);
      
      System.out.println("alice1 == alice2: " + (alice1 == alice2));
      System.out.println("alice1 == alice3: " + (alice1 == alice3));
      System.out.println("alice1.equals(alice3): " + alice1.equals(alice3));
      
      System.out.println("bob1 == bob2: " + (bob1 == bob2));
      System.out.println("bob1 == bob3: " + (bob1 == bob3));
      System.out.println("bob1.equals(bob3): " + bob1.equals(bob3));
      
      System.out.println("david1 == david2: " + (david1 == david2));
      System.out.println("david1 == david3: " + (david1 == david3));
      System.out.println("david1.equals(david3): " + david1.equals(david3));
      
      System.out.println("frank1 == frank2: " + (frank1 == frank2));
      System.out.println("frank1 == frank3: " + (frank1 == frank3));
      System.out.println("frank1.equals(frank3): " + frank1.equals(frank3));
       
      /* 	toString overriding Test를 위한 코드
      Employee bob = new CommissionEmployee("Bob", "11112", 1000.0, 0.2);
      Employee david = new HourlyEmployee("David", "11113", 5000.0, 5.0);
      Employee frank = new Manager("Frank", "11114", 2000.0);
      */
      /* 	toString overriding Test를 위한 코드
      System.out.println("alice1.toString(): " + alice1);
      System.out.println("bob.toString(): " + bob);
      System.out.println("david.toString(): " + david);
      System.out.println("frank.toString(): " + frank);
      */
   }
}