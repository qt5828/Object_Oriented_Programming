package lab_B_10_201921195;

import java.util.Arrays;

public class WordSortTest {

	public static void main(String[] args) {
		String[] names= {"Lee","Chang","Hong"};
		
		//sorting with LengthComparator
		Arrays.sort(names, new LengthComparator());
		for(String name : names)
			System.out.println(name);
		
		System.out.println();
		
		//sorting with lambda expression
		Arrays.sort(names, (first,second)->second.length()-first.length());
		for(String name : names)
			System.out.println(name);
	}

}
