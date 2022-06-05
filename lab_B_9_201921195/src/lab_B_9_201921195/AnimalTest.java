package lab_B_9_201921195;

public class AnimalTest
{
	public static void main(String[] args) {
		Animal[] animals = new Animal[3];
		animals[0] = new Dog();
		animals[1] = new Cat();
		animals[2] = new Duck();
		
		for (int i=0;i<3;i++) {
			animals[i].cry();
		}
	}
}