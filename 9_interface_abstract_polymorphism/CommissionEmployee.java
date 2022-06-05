// CommissionEmployee.java
// CommissionEmployee class extends Employee.
package lab_B_9_201921195;

public class CommissionEmployee extends Employee 
{
   private double grossSales; // gross weekly sales
   private double commissionRate; // commission percentage

   // constructor
   public CommissionEmployee(String name, String ssn, double grossSales, 
      double commissionRate)
   {
      super(name, ssn);

      if (commissionRate <= 0.0 || commissionRate >= 1.0) // validate 
         throw new IllegalArgumentException(
            "Commission rate must be > 0.0 and < 1.0");

      if (grossSales < 0.0) // validate
         throw new IllegalArgumentException("Gross sales must be >= 0.0");

      this.grossSales = grossSales;
      this.commissionRate = commissionRate;
   } 

   // set gross sales amount
   public void setGrossSales(double grossSales)
   {
      if (grossSales < 0.0) // validate
         throw new IllegalArgumentException("Gross sales must be >= 0.0");

      this.grossSales = grossSales;
   } 

   // return gross sales amount
   public double getGrossSales()
   {
      return grossSales;
   } 

   // set commission rate
   public void setCommissionRate(double commissionRate)
   {
      if (commissionRate <= 0.0 || commissionRate >= 1.0) // validate
         throw new IllegalArgumentException(
            "Commission rate must be > 0.0 and < 1.0");

      this.commissionRate = commissionRate;
   } 

   // return commission rate
   public double getCommissionRate()
   {
      return commissionRate;
   } 

   // calculate earnings; override abstract method earnings in Employee
   @Override                                                           
   public double getEarnings()                                            
   {                                                                   
      return getCommissionRate() * getGrossSales();                    
   }              
   
   @Override
   public String toString() {
	   return super.toString() + "[grossSales=" + grossSales + ",commissionRate=" + commissionRate +"]";
   }

   @Override
   public boolean equals(Object otherObject)
   {   // super.equals checks  that ¡°this¡± and other belong to the same class
        if ( ! super.equals(otherObject) )
              return false;  
        CommissionEmployee other = (CommissionEmployee) otherObject;
        if (this.grossSales!=other.grossSales)
        	return false;
        return this.commissionRate == other.commissionRate; // compare fields 
   }

} // end class CommissionEmployee