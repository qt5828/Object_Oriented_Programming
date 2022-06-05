package lab_B_12_201921195;
import java.util.*;

public class ArraysListTest {
	public static void main(String[] args) {
		ArrayList<Employee>staff=new ArrayList<>();
		staff.add(new Employee("Carl Cracker",75000,1987,12,15));
		staff.add(new Employee("Harry Hacker",50000,1989,10,1));
		staff.add(new Employee("Tony Tester",40000,1990,3,15));
	
		for(Employee e : staff)
			e.raiseSalary(5);
		
		ArrayList<String>ToString=new ArrayList<>();
		for(Employee e : staff)
			ToString.add("name=" + e.getName() + ",salary=" + e.getSalary()+",hireDay="+e.getHireDay());
		
		for(int i=ToString.size();i>0;i--){
			String s = ToString.remove(i-1);
			System.out.println(s);
		}
		
		//for(Employee e : staff)
		//	System.out.println("name="+e.getName()+",salary="+e.getSalary()+",hireDay="+e.getHireDay());
	}
}
