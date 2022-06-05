package lab_B_12_201921195;

public class PairTest3 {

	public static void main(String[] args) {
		Employee e1 = new Employee("Carl Cracker", 75000, 2007, 12, 15);
		Employee e2 = new Employee("Gus Greedy", 80000, 2000, 1, 15);
		Pair<Employee> p = new Pair<>(e1,e2);
		System.out.println(p.getFirst());
		System.out.println(p.getSecond());
		
		Employee e3 = new Employee("Sid Sneaky", 100000, 1989, 1, 1);
		
		changePartner(p,e3);
		System.out.println(p.getFirst());
		System.out.println(p.getSecond());
		
		Manager m1 = new Manager("Gang Gamchan", 75000, 2007, 12, 15);
		Manager m2 = new Manager("Yang Manchun", 80000, 2000, 1, 15);
		Pair<Manager> p2 = new Pair<>(m1,m2);
		System.out.println(p2.getFirst());
		System.out.println(p2.getSecond());
		
		Manager m = new Manager("Lee Sunshin", 100000,1989,1,1);
		
		changePartner(p2,m);
		System.out.println(p2.getFirst());
		System.out.println(p2.getSecond());
	}
	
	public static void changePartner(Pair<? extends Employee> p, Employee e) {
		p.setSecond(e);
	}
}
