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
		boolean TF;//�������� Ȯ���ϱ� ���� ����
		GregorianCalendar calendar = new GregorianCalendar(yy,mm,dd);
		TF = calendar.isLeapYear(yy);//�����̸� TF�� true
		
		//dd�� 1~31���̿� ���� ������ false��ȯ
		if (dd>31 || dd<1)
			return false;
		//mm�� 1~12���̿� ���� ������ false��ȯ
		if (mm>12 || mm<1)
			return false;
		
		switch(mm) {
		//4,6,8,11���� 30�ϱ��� �����Ƿ�, dd�� 30�� ������ false��ȯ
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
		//2������ ������ ���, dd�� 29���� ������ false��ȯ
		//������ �ƴѰ��, dd�� 28���� ������ false��ȯ
		case 2 :
			if(TF==false && dd>28)
				return false;
			else if(TF==true && dd>29)
				return false;
		}
		//��ȿ�� mm,dd�� �����ٸ� true��ȯ
		return true;
	}
}
