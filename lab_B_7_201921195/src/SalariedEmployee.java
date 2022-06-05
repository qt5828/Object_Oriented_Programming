// SalariedEmployee.java
// SalariedEmployee concrete class extends abstract class Employee.

public class SalariedEmployee extends Employee 
{
   private double weeklySalary;

   // constructor
   public SalariedEmployee(String name, String ssn, double weeklySalary)
   {
      super(name, ssn); 

      System.out.println("This is SalariedEmployee's constructor");
      
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

   // calculate earnings; override abstract method earnings in Employee
   @Override                                                           
   public double getEarnings()                                            
   {                                                                   
      return weeklySalary;
   }                                             

 } // end class SalariedEmployee
