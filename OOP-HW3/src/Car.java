
public class Car 
{
	private int num;
	private Time in;
	private Time out;
	private int cost;
	private boolean now; //���� �����忡 �ִ��� ǥ��, ������:true, ������x:false
	private int duration;
	
	public Car() {
		this.num=0;
		this.now=false;
	}
	
	public Car(int n, Time in) {
		this.num=n; 
		this.in=in;
		this.out=new Time(0,0,0,0,0);
		this.now=true;
	}
	public int Duration()
	{
		int min;
		min = this.in.CalTime(this.out);
		return min;
	}
	public int getNum() { return num; }
	public Time getIn() { return in; }
	public Time getOut() { return out; }
	public int getCost() { return cost; }
	public boolean getNow() { return now; }
	public int getDuration() { return duration; }
	public void setDuration(int d) { duration = d; }
	public void setOut(int y, int m, int d, int h, int mm) 
	{
		this.out.setTime(y, m, d, h, mm);
	}
	//�����Ǿ����� �������� �ٲٱ� ����(������)
	public void outNow() { this.now=false; }
	public int CalCost() { return 0; }
}
