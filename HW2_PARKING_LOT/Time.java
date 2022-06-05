import java.util.GregorianCalendar;

public class Time 
{
	private int year;
	private int month;
	private int day;
	private int hour;
	private int min;
	
	public Time(int y, int m, int d, int h, int mm)
	{
		this.year=y; 
		this.month=m; 
		this.day=d; 
		this.hour=h; 
		this.min=mm; 
	}
	
	public void setTime(int y, int m, int d, int h, int mm) {
		year=y; month=m; day=d; hour=h; min=mm;
	}
	
	public int getYear() { return year; }
	public int getMonth() { return month; }
	public int getDay() { return day; }
	public int getHour() { return hour; }
	public int getMin() { return min; }
	
	//두 시간차이를 계산해 분단위로 반환하는 함수
	public int CalTime(Time other)
	{
		int min;
		min=(other.day-this.day)*24*60+(other.hour*60+other.min)-(this.hour*60+this.min);
		return min;
	}
	
	//날짜,시간에 따른 유효성 검사
	public static boolean isValid(int y, int m, int d, int h, int mm) {
		boolean TF;
		GregorianCalendar calendar = new GregorianCalendar(y,m,d,h,mm);
		TF=calendar.isLeapYear(y);
		//연도가 음수일때
		if(y<0)
			return false;
		//날짜가 1과 31사이가 아닐때
		if(d>31 || d<1)
			return false;
		//월이 1과 12사이가 아닐때
		if(m>12 || m<1)
			return false;
		//시간이 0과 23사이가 아닐때
		if(h>23 || h<0)
			return false;
		//분이 0과 60사이가 아닐때
		if(mm>60 || mm<0)
			return false;

		//30일까지 있는 달인데, 31일이 입력될때
		//윤달일때
		switch(m) {
		case 4 :
			if(d>30)
				return false;
		case 6 :
			if(d>30)
				return false;
		case 9 :
			if(d>30)
				return false;
		case 11 :
			if(d>30)
				return false;
		case 2 :
			if(TF==false && d>28)
				return false;
			else if(TF==true&&d>29)
				return false;
		}
		
		return true;
	}
	
	//입차시간과 출차시간에 대한 유효성 검사
	public static boolean isValid2(Time in, Time out)
	{
		if(in.year > out.year)
			return false;
		else if(in.year < out.year)
			return true;
		else {
			if(in.month > out.month)
				return false;
			else if(in.month < out.month)
				return true;
			else {
				if(in.day > out.day)
					return false;
				else if(in.day < out.day)
					return true;
				else {
					if(in.hour > out.hour)
						return false;
					else if(in.hour < out.hour)
						return true;
					else {
						if(in.min > out.min)
							return false;
						else 
							return true;
					}
				}
			}
		}
	}
}
