package lab_B_9_201921195;

public class AbleToCryTest {

	public static void main(String[] args) {
		AbleToCry[] cryings = new AbleToCry[4];
		cryings[0] = new Dog();
		cryings[1] = new Cat();
		cryings[2] = new Duck();
		cryings[3] = new Siren();
		
		for(int i=0; i<4; i++)
			cryings[i].cry();

	}

}
