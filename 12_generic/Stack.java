package lab_B_12_201921195;
import java.util.*;

public class Stack<T> {
	private ArrayList<T>stack;
	private int top;
	public Stack()
	{
		stack = new ArrayList<>();
	}
	public void push(T s) {
		stack.add(top, s);
		top++;
	}
	public T pop() {
		top--;
		return stack.remove(top);
	}
}
