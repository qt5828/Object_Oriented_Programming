// Employee.java
// Employee abstract superclass.
package lab_B_9_201921195;

public abstract class Employee 
{
   private final String name;
   private final String ssn;

   // constructor
   public Employee(String name,String ssn)
   {
      this.name = name;                                    
      this.ssn = ssn;         
   } 

   // return name
   public String getName()
   {
      return name;
   } 

   // return social security number
   public String getSsn()
   {
      return ssn;
   } 

   @Override
   public String toString()
   {
       return getClass().getName()+"[name="+name+",ssn="+ssn+"]";
   }

  @Override
  public boolean equals(Object otherObject)
  {
     if (this == otherObject) return true;
     if (otherObject == null) return false;
     if (getClass() != otherObject.getClass()) return false;

     Employee other = (Employee) otherObject;
     return name.equals(other.name) && ssn.equals(other.ssn);
  }


   // abstract method must be overridden by concrete subclasses
   public abstract double getEarnings(); // no implementation here

} // end abstract class Employee
