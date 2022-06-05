package lab_B_9_201921195;

public abstract class Animal 
{
	public abstract void cry();
}

class Dog extends Animal implements AbleToCry
{
	public void cry() {
		System.out.println("Bow Wow!");
	}
}

class Cat extends Animal implements AbleToCry
{
	public void cry() {
		System.out.println("Meow!");
	}
}

class Duck extends Animal implements AbleToCry
{
	public void cry() {
		System.out.println("Quack Quack!");
	}
}

class Siren implements AbleToCry
{
	public void cry() {
		System.out.println("wee-oww wee-oww!");
	}
}
