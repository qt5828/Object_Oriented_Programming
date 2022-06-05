
public class Electric extends Normal {
	
	private double battery;
	public Electric(int n, Time in, double b) {
		super(n,in);
		this.battery=b;
	}
	
	public void setBattery(double b) {
		this.battery=b;
	}
	
	@Override	
	public int CalCost() {
		int pcost, bcost; //주차비용, 배터리충전비용
		int min = this.Duration();
		int dur = this.Duration();
		
		//주차비용 계산
		if(min<=30) {
			setDuration(30);
			pcost=1000;
		}
		else {
			min=min-30;
			if(min%10==0) {
				setDuration(30+(min/10)*10);
				pcost=(min/10)*500+1000;
			}
			else {
				setDuration(30+(min/10)*10+10);
				pcost=((min/10)+1)*500+1000;
			}
		}
		
		//배터리충전비용 계산
		if (min>=5*(60-battery)) {
			bcost=(int)(5*(60-battery)*60);
			setBattery(60);
			}
		else {
			bcost=60*dur;
			setBattery(battery+0.2*dur);
		}
		//밑에꺼는 걍 테스트용
		//System.out.printf("pcost = %d, bcost = %d, t = %d\n",pcost,bcost,dur);
		return pcost+bcost;
	}
}
