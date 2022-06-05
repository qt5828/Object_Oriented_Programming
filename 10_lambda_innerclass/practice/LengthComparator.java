package lab_B_10_201921195;
import java.util.*;

public class LengthComparator implements Comparator<String> {
	public int compare(String first, String second)
	{
		return first.length()-second.length();
	}
}
