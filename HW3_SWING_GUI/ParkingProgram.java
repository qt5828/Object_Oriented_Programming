import java.util.Scanner;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

//Parking Program을 실행시키는 Main이 있는 class
public class ParkingProgram {
	
	private static int size = 100; //주차 최대 차량 수
	public static Car[] Cars = new Car[size]; //배열형태의 주차장
	public static int count=0; //주차장에 있는 차량수
	public static int COST=0; //총수입
	
	
	//main
	public static void main(String[] args) {
		
		//주차장 초기화
		ParkingProgram.Init();
		EventQueue.invokeLater(()->
		{
			JFrame frame = new ParkingFrame();
			frame.setTitle("Parking Program");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
		

	}
	//주차장 초기화
	public static void Init() {
		for(int i=0;i<size;i++) {
			Cars[i] = new Car();
		}
	}
	//주차장의 빈자리 인덱스 체크
	public static int check() {
		for(int i=0;i<size;i++) {
			if(!Cars[i].getNow())
				return i;
		}
		return -1;
	}
	//주차장 사이즈 반환
	public static int getSize() {
		return size;
	}
	//입차시간을 비교하는 method
	public static int compare(Car a, Car b) {
		if(a.getIn().getYear() > b.getIn().getYear())
			return 1;
		else if(a.getIn().getYear() < b.getIn().getYear())
			return -1;
		else {
			if(a.getIn().getMonth() > b.getIn().getMonth())
				return 1;
			else if(a.getIn().getMonth() < b.getIn().getMonth())
				return -1;
			else 
			{
				if(a.getIn().getDay() > b.getIn().getDay())
					return 1;
				else if(a.getIn().getDay() < b.getIn().getDay())
					return -1;
				else {
					if(a.getIn().getHour() > b.getIn().getHour())
						return 1;
					else if(a.getIn().getHour() < b.getIn().getHour())
						return -1;
					else {
						if(a.getIn().getMin() > b.getIn().getMin())
							return 1;
						else if(a.getIn().getMin() < b.getIn().getMin())
							return -1;
						else
							return 0;
					}
				}
			}
		}
	}
}
