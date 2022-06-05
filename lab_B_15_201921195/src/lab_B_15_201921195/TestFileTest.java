package lab_B_15_201921195;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class TestFileTest {
	
	public static void main(String[] args) throws IOException{
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Carl Cracker",75000,1987,12,15);
		staff[1] = new Employee("Harry Hacker",50000,1989,10,1);
		staff[2] = new Employee("Tony Tester",40000,1990,3,15);
		
		StringWriter writer = new StringWriter();
		try(PrintWriter out = new PrintWriter(writer))
		{
			writeData(staff,out); 
		}
		System.out.println(writer.toString());
		
	}
	
	private static void writeData(Employee[] employees,PrintWriter out) throws IOException
	{
		//write number of employees
		out.println(employees.length);
		for(Employee e : employees)
			writeEmployee(out,e);
	}
	public static void writeEmployee(PrintWriter out, Employee e)
	{
		out.println(e.getName()+"|"+e.getSalary()+"|"+e.getHireDay());
	}
	private static Employee[] readData(Scanner in)
	{
		//retrieve the array size
		int n = in.nextInt();
		in.nextLine(); //consume newline
		Employee[] employees = new Employee[n];
		for(int i=0;i<n;i++)
		{
			employees[i] = readEmployee(in);
		}
		return employees;
	}
	public static Employee readEmployee(Scanner in)
	{
		String line = in.nextLine();
		String[] tokens = line.split("\\|");
		String name = tokens[0];
		double salary = Double.parseDouble(tokens[1]);
		LocalDate hireDate = LocalDate.parse(tokens[2]);
		int year = hireDate.getYear();
		int month = hireDate.getMonthValue();
		int day = hireDate.getDayOfMonth();
		return new Employee(name,salary,year,month,day);
	}

}
