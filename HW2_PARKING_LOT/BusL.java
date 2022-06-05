
public class BusL extends Bus{

	public BusL(int n, Time in) {
		super(n,in);
	}
	
	@Override	
	public int CalCost() {
		int min = Duration();
		if(min<=60) {
			setDuration(60);
			return 4000;
		}
		else {
			min=min-60;
			if(min%30==0) {
				setDuration(60+(min/30)*30);
				return (min/30)*2000+4000;
			}
			else {
				setDuration(60+(min/30)*30+30);
				return ((min/30)+1)*2000+4000;
			}
		}
	}
}
