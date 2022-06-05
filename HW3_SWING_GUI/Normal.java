
public class Normal extends Car 
{
	public Normal(int n, Time in) {
		super(n,in);
	}
	
	public Normal()
	{
		super();
	}
	
	@Override	
	public int CalCost() {
		int min = this.Duration();
		if(min<=30) {
			setDuration(30);
			return 1000;
		}
		else {
			min=min-30;
			if(min%10==0) {
				setDuration(30+(min/10)*10);
				return (min/10)*500+1000;
			}
			else {
				setDuration(30+(min/10)*10+10);
				return ((min/10)+1)*500+1000;
			}
		}
	}
}
