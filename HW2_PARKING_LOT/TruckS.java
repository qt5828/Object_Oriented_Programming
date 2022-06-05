
public class TruckS extends Truck {
	public TruckS(int n, Time in) {
		super(n,in);
		}
	@Override	
	public int CalCost() {
		int min = Duration();
		
		if(min%60==0) {
			setDuration((min/60)*60);
			return (min/60)*2000;
		}
		else {
			setDuration((min/60)*60+60);
			return ((min/60)+1)*2000;
		}
	}
	
}
