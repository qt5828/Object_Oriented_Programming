
public class TruckL extends Truck {
	public TruckL(int n, Time in) {
		super(n,in);
	}
	@Override	
	public int CalCost() {
		int min = Duration();
		
		if(min%60==0) {
			setDuration((min/60)*60);
			return (min/60)*4000;
		}
		else {
			setDuration((min/60)*60+60);
			return ((min/60)+1)*4000;
		}
	}
}
