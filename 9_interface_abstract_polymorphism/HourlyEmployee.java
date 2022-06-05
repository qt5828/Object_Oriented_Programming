// Fig. 10.6: HourlyEmployee.java
// HourlyEmployee class extends Employee.
package lab_B_9_201921195;

public class HourlyEmployee extends Employee 
{
   private double wage; // wage per hour
   private double hours; // hours worked for week

   // constructor
   public HourlyEmployee(String name,
      String ssn, double wage, double hours)
   {
      super(name, ssn);

      if (wage < 0.0) // validate wage
         throw new IllegalArgumentException(
            "Hourly wage must be >= 0.0");

      if ((hours < 0.0) || (hours > 168.0)) // validate hours
         throw new IllegalArgumentException(
            "Hours worked must be >= 0.0 and <= 168.0");

      this.wage = wage;
      this.hours = hours;
   } 

   // set wage
   public void setWage(double wage)
   {
      if (wage < 0.0) // validate wage
         throw new IllegalArgumentException(
            "Hourly wage must be >= 0.0");

      this.wage = wage;
   } 

   // set hours worked
   public void setHours(double hours)
   {
      if ((hours < 0.0) || (hours > 168.0)) // validate hours
         throw new IllegalArgumentException(
            "Hours worked must be >= 0.0 and <= 168.0");

      this.hours = hours;
   } 

   // calculate earnings; override abstract method earnings in Employee
   @Override                                                           
   public double getEarnings()                                            
   {                                                                   
      if (hours <= 40) // no overtime                           
         return wage * hours;                                
      else                                                             
         return 40 * wage + (hours - 40) * wage * 1.5;
   }        
   
   @Override
   public String toString() {
	   return super.toString() + "[wage=" + wage + ",hours=" + hours +"]";
   }
   
   @Override
   public boolean equals(Object otherObject)
   {   // super.equals checks  that ¡°this¡± and other belong to the same class
        if ( ! super.equals(otherObject) )
              return false;  
        HourlyEmployee other = (HourlyEmployee) otherObject;
        if(this.wage!=other.wage)
        	return false;
        return this.hours == other.hours; // compare fields 
   }


} // end class HourlyEmployee
