package lab_B_10_201921195;
import java.math.*;

public class IntegralTest {

	public static double integral(F f, double a, double b, int n)
	{
		int i;
		double sum=0;
		double dt = (b-a)/n;
		for(i=0;i<n;i++)
			sum+=f.apply(a+(i+0.5)*dt);
		return sum*dt;
	}
	
	public static void main(String[] args) 
	{
		F f;
		double r=0.0;
		
		f = x->Math.sin(x);
		int n;
		for(n=100; n<500; n++) {
			r = integral(f,0,Math.PI,n);
			System.out.printf("f(x)=sin(x), 0, PI, %d: %.5f%n",n, r);
		}
	}

}
