package lab_B_6_201921195;

public class Employee 
{	
	private final String name;
	private double salary;
	private final Date hireDay;
	
	public Employee(String n, double s, int year, int month, int day)
	{
		name = n;
		salary = s;
		hireDay = new Date(year,month,day);
	}
	public Employee(String n, double s, Date d)
	{
		name = n;
		salary = s;
		hireDay = d;
	}
	public String getName() {return name;}
	public double getSalary() {return salary;}
	public Date getHireDay() {return hireDay;}
	
	public void raiseSalary(double byPercent)
	{
		double raise = salary*byPercent/100;
		salary+=raise;
	}
	
}
