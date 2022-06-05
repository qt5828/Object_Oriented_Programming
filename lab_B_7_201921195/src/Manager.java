// Manager.java
// Manager class extends SalariedEmployee.

public class Manager extends SalariedEmployee 
{
   private double bonus; // weekly bonus

   // constructor
   public Manager(String name, String ssn, double weeklySalary)
   {
      super(name, ssn, weeklySalary);
      
      System.out.println("This is Manager's constructor");
      bonus = 0.0;
   }

   public void setBonus(double bonus) 
   {
      this.bonus = bonus;
   }

   // calculate earnings; override method earnings in CommissionEmployee
   @Override                                                            
   public double getEarnings()                                             
   {                                                                    
	   return super.getEarnings() + bonus;        
   } 

} // end class BasePlusCommissionEmployee
