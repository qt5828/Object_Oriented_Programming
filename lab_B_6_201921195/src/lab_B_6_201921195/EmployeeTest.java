package lab_B_6_201921195;

import java.util.Scanner;


public class EmployeeTest {
	public static void main(String[] agrs)
	{
		Scanner in = new Scanner(System.in);
		int yy,mm,dd;
		while(true) {
			System.out.println("�� : ");
			yy = in.nextInt();
			System.out.println("�� : ");
			mm = in.nextInt();
			System.out.println("�� : ");
			dd = in.nextInt();
			if(Date.isValid(yy,mm,dd)==true)
				break;
			System.out.println("��ȿ���� ���� ���� �Է��ϼ̽��ϴ�.\n�ٽ� �Է��ϼ���.");
		}
		Date d = new Date(yy,mm,dd);
		//Employee e = new Employee("Hong", 100000.0, d);
		Employee e = new Employee("Hong", 100000.0, d);
		printEmployee(e);
		Date d2 = e.getHireDay();
		d2.setDate(new Date(2020,3,15));
		printEmployee(e);
	}
	public static void printEmployee(Employee e)
	{
		System.out.println("Name: "+e.getName());
		System.out.println("Salary: "+e.getSalary());
		System.out.println("Hireday: "+e.getHireDay().toString());
	}
}
