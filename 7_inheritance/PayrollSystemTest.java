// PayrollSystemTest.java

public class PayrollSystemTest 
{
   public static void main(String[] args) 
   {
  
      // create four-element Employee array
      Employee[] employees = new Employee[5]; 

      // initialize array with Employees
      employees[0] = new SalariedEmployee("John", "111-11-1111", 800.00);
      employees[1] = new HourlyEmployee("Karen", "222-22-2222", 16.75, 40);
      employees[2] = new CommissionEmployee("Sue", "333-33-3333", 10000, .06);
      employees[3] = new Manager("Bob", "444-44-4444", 2500.0);
      employees[4] = new BasePlusCommissionEmployee("Sue", "333-33-3333", 10000, .06,1000.0);
      System.out.printf("Employees processed polymorphically:%n%n");
      
      // generically process each element in array employees
	  
      for (Employee currentEmployee : employees) 
      {

         // determine whether element is a Manager
         if (currentEmployee instanceof Manager) 
         {
            // downcast Employee reference to Manager reference
            Manager employee =  (Manager) currentEmployee;
            employee.setBonus(100.0);
         } 

         System.out.printf("%s earned $%,.2f%n%n", currentEmployee.getName(),
             currentEmployee.getEarnings());
      } 
      //Manager manager = (Manager) employees[3];
      //manager.setBonus(1000.0);
      
      //System.out.printf("%s %s: $%,.2f%n%n", employees[3].getName(),"earned",employees[3].getEarnings());
     
  
   } // end main
} // end class PayrollSystemTest

