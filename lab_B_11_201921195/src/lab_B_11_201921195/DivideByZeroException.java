package lab_B_11_201921195;

public class DivideByZeroException extends ArithmeticException
{
	public DivideByZeroException() {}
	public DivideByZeroException(String gripe)
	{
		super(gripe);
	}
	
}
