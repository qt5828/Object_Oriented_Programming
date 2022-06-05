package lab_B_11_201921195;
import java.io.*;

public class FileInputTest {

	public static FileInputStream f1(String fileName) throws IOException
	{
		FileInputStream fis = new FileInputStream(fileName);
		
		System.out.println("f1: File input stream created");
		return fis;
	}
	public static void main(String[] args) {
		FileInputStream fis1 = null;
		String fileName = "foo.bar";
		
		System.out.println("main: Starting "+FileInputTest.class.getName()+" with file name= "+fileName);
		try {
			fis1 = f1(fileName);
		}
		catch(IOException Ex){
			System.err.printf("%nException: %s%n", Ex);
			return;
		}

		System.out.println("main: "+ FileInputTest.class.getName() + " ended");
	}
}
