import java.util.Scanner;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

//Parking Program�� �����Ű�� Main�� �ִ� class
public class ParkingProgram {
	
	private static int size = 100; //���� �ִ� ���� ��
	public static Car[] Cars = new Car[size]; //�迭������ ������
	public static int count=0; //�����忡 �ִ� ������
	public static int COST=0; //�Ѽ���
	
	
	//main
	public static void main(String[] args) {
		
		//������ �ʱ�ȭ
		ParkingProgram.Init();
		EventQueue.invokeLater(()->
		{
			JFrame frame = new ParkingFrame();
			frame.setTitle("Parking Program");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
		

	}
	//������ �ʱ�ȭ
	public static void Init() {
		for(int i=0;i<size;i++) {
			Cars[i] = new Car();
		}
	}
	//�������� ���ڸ� �ε��� üũ
	public static int check() {
		for(int i=0;i<size;i++) {
			if(!Cars[i].getNow())
				return i;
		}
		return -1;
	}
	//������ ������ ��ȯ
	public static int getSize() {
		return size;
	}
	//�����ð��� ���ϴ� method
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
