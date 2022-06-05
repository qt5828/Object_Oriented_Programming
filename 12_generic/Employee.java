package lab_B_12_201921195;
import java.time.LocalDate;
public class Employee
{
   private String name;
   private double salary;
   private LocalDate hireDay;

   public Employee(String n, double s, int y, int m, int d)
   {
      this.name = n;
      this.salary = s;
      hireDay = LocalDate.of(y, m, d);
   }

   public String getName()
   {
      return name;
   }

   public double getSalary()
   {
      return salary;
   }
   
   public LocalDate getHireDay()
   {
	   return hireDay;
   }

   public void raiseSalary(double byPercent)
   {
      double raise = salary * byPercent / 100;
      salary += raise;
   }

}