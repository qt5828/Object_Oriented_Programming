// Manager.java
// Manager class extends SalariedEmployee.
package lab_B_9_201921195;

public class Manager extends SalariedEmployee 
{
   private double bonus; // weekly bonus

   // constructor
   public Manager(String name, String ssn, double weeklySalary)
   {
      super(name, ssn, weeklySalary);
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
   
   @Override
   public String toString()
   {
      return super.toString();
   }
   @Override
   public boolean equals(Object otherObject)
   {   // super.equals checks  that ¡°this¡± and other belong to the same class
        if ( ! super.equals(otherObject) )
              return false;  
        return true;
   }


} // end class BasePlusCommissionEmployee
