// SalariedEmployee.java
// SalariedEmployee concrete class extends abstract class Employee.
package lab_B_9_201921195;

public class SalariedEmployee extends Employee 
{
   private double weeklySalary;

   // constructor
   public SalariedEmployee(String name, String ssn, double weeklySalary)
   {
      super(name, ssn); 

      if (weeklySalary < 0.0)
         throw new IllegalArgumentException(
            "Weekly salary must be >= 0.0");

      this.weeklySalary = weeklySalary;
   } 

   // set salary
   public void setWeeklySalary(double weeklySalary)
   {
      if (weeklySalary < 0.0)
         throw new IllegalArgumentException(
            "Weekly salary must be >= 0.0");

      this.weeklySalary = weeklySalary;
   } 

   public void raiseSalary(double rate)
  {
      weeklySalary += (weeklySalary * rate/100);
   }

  @Override
  public String toString()
  {
     return super.toString() + "[weeklySalary=" + weeklySalary + "]";
  }

  @Override
  public boolean equals(Object otherObject)
  {   // super.equals checks  that ¡°this¡± and other belong to the same class
       if ( ! super.equals(otherObject) )
             return false;  
       SalariedEmployee other = (SalariedEmployee) otherObject;
       return this.weeklySalary == other.weeklySalary; // compare fields 
  }


   // calculate earnings; override abstract method earnings in Employee
   @Override                                                           
   public double getEarnings()                                            
   {                                                                   
      return weeklySalary;
   }                                             

 } // end class SalariedEmployee

