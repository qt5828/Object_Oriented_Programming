package lab_B_12_201921195;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> ss = new Stack<>();
		Stack<Employee> sc = new Stack<>();
		
		ss.push("a");
		ss.push("b");
		ss.push("c");
		System.out.println(ss.pop());
		
		sc.push(new Employee("Jo", 5000, 2020, 11, 18));
		sc.push(new Employee("Woo", 7000, 2020, 04, 17));
		sc.push(new Employee("Yeon", 4000, 2020, 9, 30));
		Employee e = sc.pop();
		System.out.println("name=" + e.getName() + ",salary=" + e.getSalary()+",hireDay="+e.getHireDay());
	}

}
