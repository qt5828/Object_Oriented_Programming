package lab_B_6_201921195;

import java.util.GregorianCalendar;

public class Date {
	private int year;
	private int month;
	private int day;
	
	public Date (int yy, int mm, int dd)
	{
		year=yy;
		month=mm;
		day=dd;
	}
	//public int getYear() { return year; }
	//public int getMonth() { return month; }
	//public int getDay() { return day; }
	public void setDate(Date d)
	{
		this.year = d.year;
		this.month = d.month;
		this.day = d.day;
	}
	public String toString()
	{
		return year+":"+month+":"+day;
	}
	public static boolean isValid(int yy, int mm, int dd)
	{
		boolean TF;//윤달인지 확인하기 위한 변수
		GregorianCalendar calendar = new GregorianCalendar(yy,mm,dd);
		TF = calendar.isLeapYear(yy);//윤달이면 TF는 true
		
		//dd가 1~31사이에 있지 않으면 false반환
		if (dd>31 || dd<1)
			return false;
		//mm이 1~12사이에 있지 않으면 false반환
		if (mm>12 || mm<1)
			return false;
		
		switch(mm) {
		//4,6,8,11월은 30일까지 있으므로, dd가 30이 넘으면 false반환
		case 4 :
			if(dd>30)
				return false;
		case 6 :
			if(dd>30)
				return false;
		case 9 :
			if(dd>30)
				return false;
		case 11 :
			if(dd>30)
				return false;
		//2월에는 윤달인 경우, dd가 29일을 넘으면 false반환
		//윤달이 아닌경우, dd가 28일을 넘으면 false반환
		case 2 :
			if(TF==false && dd>28)
				return false;
			else if(TF==true && dd>29)
				return false;
		}
		//유효한 mm,dd를 가졌다면 true반환
		return true;
	}
}
